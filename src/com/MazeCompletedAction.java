package com;

import maze.MazeController;
import entities.EntityController;

public interface MazeCompletedAction {
	void mazeCompleted(EntityController entity, MazeController maze);
}
