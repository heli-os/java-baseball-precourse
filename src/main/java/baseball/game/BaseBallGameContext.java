package baseball.game;

import baseball.domain.computer.Computer;
import baseball.domain.number.BaseBallNumber;
import baseball.domain.player.Player;
import baseball.domain.scene.BaseBallGameScene;
import baseball.domain.scene.Playing;
import baseball.domain.scene.ReadyToStart;
import baseball.port.inbound.StandardInput;
import baseball.port.outbound.StandardOutput;

import java.util.List;

/**
 * @author Heli
 * Created on 2022. 09. 28
 */
public class BaseBallGameContext {

    private final Compare compare = new Compare();
    private BaseBallGameScene scene = new ReadyToStart();
    private Computer computer;
    private Player player;

    public void play() {
        this.scene = this.scene.next(this);
    }

    public void init() {
        this.computer = new Computer();
        this.scene = new Playing();
    }

    public void userInput() {
        StandardOutput.print("숫자를 입력해주세요: ");
        this.player = new Player(StandardInput.readLine());
    }

    public CompareResult compare(final List<BaseBallNumber> inputNumbers, final List<BaseBallNumber> resultNumbers) {
        return compare.compare(inputNumbers, resultNumbers);
    }

    public List<BaseBallNumber> playerInputNumbers() {
        return this.player.inputNumbers().numbers();
    }

    public List<BaseBallNumber> computerResultNumbers() {
        return this.computer.resultNumbers().numbers();
    }

    public boolean playable() {
        return this.scene.playable();
    }
}
