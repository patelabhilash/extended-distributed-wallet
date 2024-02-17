
CREATE TABLE accident
(
  id            BIGINT       NOT NULL,
  updated_date  timestamptz  NOT NULL,
  accident_date timestamptz  NOT NULL,
  status        VARCHAR(255) NOT NULL DEFAULT CREATED,
  PRIMARY KEY (id)
);

COMMENT ON COLUMN accident.status IS 'CREATED/REPAIRED/CLAIMED';

CREATE TABLE accident_insurance_claim
(
  id                BIGINT       NOT NULL,
  repair_expense_id BIGINT       NOT NULL,
  received_by       VARCHAR(255) NOT NULL DEFAULT BANK,
  amount            BIGINT       NOT NULL,
  received_on_date  timestamptz  NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE accident_repair_expense
(
  id           BIGINT       NOT NULL,
  accident_id  BIGINT       NOT NULL,
  journey_id   BIGINT       NOT NULL,
  paid_by      VARCHAR(255) NOT NULL,
  amount       BIGINT       NOT NULL,
  paid_on_date timestamptz  NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE D_dashboard
(
  id BIGINT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE E_event
(
  id         BIGINT       NOT NULL,
  event_type VARCHAR(255) NOT NULL,
  event_id   BIGINT       NOT NULL,
  amount     BIGINT       NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE J_journey
(
  id BIGINT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE J_journey_ledger
(
  id BIGINT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE J_journey_nonaccident_repair
(
  id BIGINT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE N_nonaccident_repair_separately
(
  id              BIGINT      NOT NULL,
  paid_on_date    timestamptz NOT NULL,
  paid_by         bigint      NOT NULL,
  repairshop_name varchar    ,
  parts_name      varchar    ,
  note            varchar    ,
  PRIMARY KEY (id)
);

CREATE TABLE O_other_transaction
(
  id               BIGINT      NOT NULL,
  transaction_date timestamptz NOT NULL,
  paid_to          BIGINT      NOT NULL,
  paid_by          BIGINT      NOT NULL,
  amount           BIGINT      NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE P_pool_management
(
  id BIGINT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE Wallet
(
  id   BIGINT       NOT NULL,
  type VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  desc VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

COMMENT ON COLUMN Wallet.type IS '(INTERNAL/EXTERNAL)';

COMMENT ON COLUMN Wallet.desc IS 'description';

ALTER TABLE accident_insurance_claim
  ADD CONSTRAINT FK_accident_repair_expense_TO_accident_insurance_claim
    FOREIGN KEY (repair_expense_id)
    REFERENCES accident_repair_expense (id);

ALTER TABLE accident_repair_expense
  ADD CONSTRAINT FK_J_journey_TO_accident_repair_expense
    FOREIGN KEY (journey_id)
    REFERENCES J_journey (id);

ALTER TABLE accident_repair_expense
  ADD CONSTRAINT FK_accident_TO_accident_repair_expense
    FOREIGN KEY (accident_id)
    REFERENCES accident (id);

ALTER TABLE O_other_transaction
  ADD CONSTRAINT FK_Wallet_TO_O_other_transaction
    FOREIGN KEY (paid_by)
    REFERENCES Wallet (id);

ALTER TABLE O_other_transaction
  ADD CONSTRAINT FK_Wallet_TO_O_other_transaction1
    FOREIGN KEY (paid_to)
    REFERENCES Wallet (id);
