# tennis-kata
tennis match management:
Use "git clone https://github.com/caninaam/tennis-kata.git".
use "mvn clean install" to build and execute unit tests.

# Test cases : 

TennisApplicationTest:
-local_simple_win_test : Local player wins the game 50-0.
-visitor_simple_win_test : Visitor player wins the game 50-0.
-visitor_win_case_deuce_test : Visitor wins deuce.
-visitor_win_game_already_finished : Case throwing managed exception GameFinichedException.

SetManagementTest
                  local_player_win_set : Simple case the Local player wins the set 7-0.
                  local_player_win_set_with_tie_break : the local Player wins by tie-break 7-0.
                  local_player_win_set_with_tie_break_seven_seven : the local Player wins by tie-break 6-8.     
                  
# Notice use state machine pattern to manage deuce     
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
