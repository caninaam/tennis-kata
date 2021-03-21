package com.amine.tennis.enums;

public enum DeuceStateMachine {
	

	   EQUALITY {
	        @Override
	        public DeuceStateMachine winPoint() {
	            return ADVANTAGE;
	        }
	    	@Override
			public DeuceStateMachine losePoint() {
				  return DISADVANTAGE;
			}
			   
	    },
	   ADVANTAGE{

		@Override
		public DeuceStateMachine winPoint() {
			  return WIN;
		}

		@Override
		public DeuceStateMachine losePoint() {
			  return EQUALITY;
		}
		   
		   
	   },
	   WIN{

		@Override
		public DeuceStateMachine winPoint() {
			return null;
		}

		@Override
		public DeuceStateMachine losePoint() {
			return null;
		}
		   
	   },
	   DISADVANTAGE{

			@Override
			public DeuceStateMachine winPoint() {
				  return EQUALITY;
			}

			@Override
			public DeuceStateMachine losePoint() {
				  return LOST;
			}
			   
			   
		   },
	   LOST{

		@Override
		public DeuceStateMachine winPoint() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public DeuceStateMachine losePoint() {
			// TODO Auto-generated method stub
			return null;
		}}
	   ;
	   
		public abstract DeuceStateMachine winPoint();
		public abstract DeuceStateMachine losePoint();
}
