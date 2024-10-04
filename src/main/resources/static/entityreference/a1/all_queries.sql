--refresh materialized view
REFRESH MATERIALIZED VIEW continuous_aggregate;
REFRESH MATERIALIZED VIEW ca_balance_all_time_all_wallet;
REFRESH MATERIALIZED VIEW ca_balance_all_time_each_wallet;
REFRESH MATERIALIZED VIEW ca_balance_daily_all_wallet;

-- wallet wise continuous aggregate
create materialized view if not exists
  continuous_aggregate as
select
  time_bucket ('1 day'::interval, created_at) as time_bucket,
  wallet_id,
  sum(amount) as sum_amount
from
  eventhub
group by
  time_bucket,
  wallet_id;

-- continuous aggregate of daily all wallet
create materialized view if not exists
  ca_balance_daily_all_wallet as
select
  time_bucket ('1 day'::interval, created_at) as time_bucket,
  sum(amount) as sum_amount
from
  eventhub
group by
  time_bucket;


  -- wallet wise continuous aggregate for all time
CREATE MATERIALIZED VIEW IF NOT EXISTS
  ca_balance_all_time_each_wallet AS
SELECT
  wallet_id,
  sum(amount) as sum_amount
FROM
  eventhub
GROUP BY
  wallet_id;

  -- total cash reserve
CREATE MATERIALIZED VIEW IF NOT EXISTS
  ca_balance_all_time_all_wallet AS
SELECT
  sum(amount) as sum_amount
FROM
  eventhub;


  -- ----------------------
  -- to query a continuous aggregate

  SELECT time_bucket, wallet_id, sum_amount FROM continuous_aggregate;

------------NOT TESTED BELOW-----
-- Create a materialized view to sum amount for a day
CREATE MATERIALIZED VIEW mv_sum_by_day AS
SELECT
  date,
  SUM(amount) AS total_amount
FROM
  your_table
GROUP BY
  date;

-- Create a materialized view to sum amount for a month
CREATE MATERIALIZED VIEW mv_sum_by_month AS
SELECT
  DATE_TRUNC('month', date) AS month,
  SUM(amount) AS total_amount
FROM
  your_table
GROUP BY
  month;

-- Create a materialized view to sum amount for a quarter
CREATE MATERIALIZED VIEW mv_sum_by_quarter AS
SELECT
  DATE_TRUNC('quarter', date) AS quarter,
  SUM(amount) AS total_amount
FROM
  your_table
GROUP BY
  quarter;

-- Create a materialized view to sum amount for a year
CREATE MATERIALIZED VIEW mv_sum_by_year AS
SELECT
  DATE_TRUNC('year', date) AS year,
  SUM(amount) AS total_amount
FROM
  your_table
GROUP BY
  year;
----------NOT TESTED ENDS--------------