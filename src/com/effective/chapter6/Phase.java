package com.effective.chapter6;

import java.util.EnumMap;
import java.util.Map;

public enum Phase {

	SOLID, LIQUID, GAS;

	public enum Transition {
		MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID), BOIL(LIQUID, GAS), CONDENSE(
				GAS, LIQUID), SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);
		
		private final Phase src;
		private final Phase dest;

		Transition(Phase src, Phase dest) {
			this.src = src;
			this.dest = dest;
		}

		private static final Transition[][] TRANSITIONS = {
				{ null, MELT, SUBLIME }, { FREEZE, null, BOIL },
				{ DEPOSIT, CONDENSE, null } };

		public static Transition from(Phase src, Phase dest) {
			// return TRANSITIONS[src.ordinal()][dest.ordinal()];
			return m.get(src).get(dest);
		}

		private static final Map<Phase, Map<Phase, Transition>> m = new EnumMap<Phase, Map<Phase, Transition>>(
				Phase.class);
		static {
			for (Phase p : Phase.values()) {
				m.put(p, new EnumMap<Phase, Transition>(Phase.class));
			}
			for (Transition trans : Transition.values()) {
				m.get(trans.src).put(trans.dest, trans);
			}
		}
	}
}
