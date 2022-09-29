package baseball.domain.scene;

import baseball.domain.number.BaseBallNumber;
import baseball.game.BaseBallGameContext;
import baseball.game.CompareResult;
import baseball.port.outbound.StandardOutput;

import java.util.List;

/**
 * @author Heli
 * Created on 2022. 09. 28
 */
public class Playing implements BaseBallGameScene {
    @Override
    public BaseBallGameScene command(final BaseBallGameContext context) {
        List<BaseBallNumber> inputNumbers = context.playerInputNumbers();
        List<BaseBallNumber> resultNumbers = context.computerResultNumbers();

        CompareResult compareResult = context.compare.compare(inputNumbers, resultNumbers);
        StandardOutput.println(compareResult);

        if (compareResult.isFinish()) {
            StandardOutput.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return new Finish();
        }
        return new WaitForUserInputNumbers();
    }

    @Override
    public boolean playable() {
        return true;
    }
}
