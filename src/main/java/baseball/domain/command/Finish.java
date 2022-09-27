package baseball.domain.command;

import baseball.game.BaseBallGameContext;
import baseball.port.inbound.StandardInput;
import baseball.port.outbound.StandardOutput;

/**
 * @author Heli
 * Created on 2022. 09. 28
 */
public class Finish implements BaseBallGameCommand {

    private static final String NEW_GAME_FLAG = "1";
    private static final String EXIT_GAME_FLAG = "2";

    @Override
    public BaseBallGameCommand command(BaseBallGameContext context) {
        StandardOutput.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = StandardInput.readLine();
        if (NEW_GAME_FLAG.equals(input)) {
            return new ReadyToStart();
        }
        if (EXIT_GAME_FLAG.equals(input)) {
            return new Exit();
        }
        throw new IllegalArgumentException("게임종료");
    }

    @Override
    public boolean playable() {
        return true;
    }
}
