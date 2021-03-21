package com.amine.tennis.enums;

import java.util.Arrays;
import java.util.Map;

public enum ScoreEnumMap {
	ZERO(0), QUINZE(1), TRENTE(2), QUARANTE(3), CINQUANTE(4);

	private int value;

	ScoreEnumMap(int i) {
		value = i;

	}

	public static ScoreEnumMap get(int code) {
		switch (code) {
		case 1:
			return QUINZE;
		case 2:
			return TRENTE;
		case 3:
			return QUARANTE;
		case 0:
			return ZERO;
		case 4:
			return CINQUANTE;
		}
		return null;
	}
}
