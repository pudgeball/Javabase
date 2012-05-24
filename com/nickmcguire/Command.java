package com.nickmcguire;

public enum Command
{
	SELECT,
	CREATE,
	CREATETABLE {
		@Override
		public String toString() {
			return "CREATE TABLE";
		}
	},
	ALTER,
	INSERT {
		@Override
		public String toString() {
			return "INSERT INTO";
		}
	},
	DROP,
	ERR
};