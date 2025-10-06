-- V3__allow_null_payment_date.sql
-- This migration updates the payroll table to allow NULL for payment_date

ALTER TABLE payroll
    ALTER COLUMN payment_date DROP NOT NULL;
