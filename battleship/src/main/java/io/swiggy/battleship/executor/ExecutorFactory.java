package io.swiggy.battleship.executor;

import io.swiggy.battleship.enums.Instruction;
import io.swiggy.battleship.executor.impl.GameInstructionExecutor;
import io.swiggy.battleship.executor.impl.NewGameExecutor;
import io.swiggy.battleship.executor.impl.ResumeGameExecutor;
import io.swiggy.battleship.executor.impl.SaveGameExecutor;
import io.swiggy.battleship.game.GameManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExecutorFactory {


    static Executor gameExecutor = new GameInstructionExecutor();
    static Executor saveGameExecutor = new SaveGameExecutor();
    static Executor resumeGameExecutor = new ResumeGameExecutor();
    static Executor newGameExecutor = new NewGameExecutor();
    private static Map<Instruction, Executor> executorMap = new HashMap<Instruction, Executor>();

    static {
        executorMap.put(Instruction.NewGame, newGameExecutor);
        executorMap.put(Instruction.SaveAndExit, saveGameExecutor);
        executorMap.put(Instruction.Attack, gameExecutor);
        executorMap.put(Instruction.ResumeGame, resumeGameExecutor);

    }

    public Executor getExecutor(Instruction instruction) {
        return executorMap.get(instruction);
    }
}
