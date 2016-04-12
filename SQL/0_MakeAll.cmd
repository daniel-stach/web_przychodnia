@echo off

copy /b 1_CreateUser.sql + 2_CreateDatabase.sql + 3_CreateTables.sql + 4_InsertData.sql 0_All.sql
