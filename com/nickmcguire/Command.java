package com.nickmcguire;

public enum Command {
	SELECT,
	CREATE,
	ALTER,
	INSERT
	{
		@Override
		public String toString() {
			return "INSERT INTO";
		}
	},
	ERR
};