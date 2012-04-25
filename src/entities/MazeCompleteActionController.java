package entities;

import game.Game;
import maze.MazeController;

import com.MazeCompletedAction;
import com.MoveDirection;

public class MazeCompleteActionController extends MoveActionController {

		private Game game;
		private EntityController entityController;
		private MazeCompletedAction callback;
		
		
		public MazeCompleteActionController(MovementListener listener, MazeCompletedAction callback, Game game, EntityController entity) {
			super(listener, null);
			this.game = game;
			this.entityController = entity;
			this.callback = callback;
		}
		
		public MazeCompleteActionController(MovementListener listener,MazeCompletedAction callback, Game game, EntityController entity, MoveActionController chain) {
			super(listener, chain);
			this.game = game;
			this.entityController = entity;	
			this.callback = callback;
		}
		
		@Override
		protected boolean checkAction(MoveDirection direction) {
			
			boolean result = game.getMaze().getMaze().getEndCell().getX() == entityController.getEntity().getPositionX() &&
							 game.getMaze().getMaze().getEndCell().getY() == entityController.getEntity().getPositionY() &&
							 direction == game.getMaze().getMaze().getEndDirection();
			
			// Call the callback.
			if (result) {
				callback.mazeCompleted(entityController, game.getMaze());
			}
			
			return super.checkAction(direction); // Must call super to try and invoke any chained Handlers.
		}
}
