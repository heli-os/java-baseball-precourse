package baseball.game;

import baseball.domain.command.BaseBallGameCommand;
import baseball.domain.command.Playing;
import baseball.domain.command.ReadyToStart;
import baseball.domain.computer.Computer;
import baseball.domain.number.BaseBallNumber;
import baseball.domain.player.Player;
import baseball.port.inbound.StandardInput;
import baseball.port.outbound.StandardOutput;

import java.util.List;

/**
 * @author Heli
 * Created on 2022. 09. 28
 */
public class BaseBallGameContext {

    public final Compare compare = new Compare();
    private BaseBallGameCommand command = new ReadyToStart();
    private Computer computer;
    private Player player;

    public void command() {
        this.command = this.command.command(this);
    }

    public void init() {
        this.computer = new Computer();
        this.command = new Playing();
    }

    public void userInput() {
        StandardOutput.print("숫자를 입력해주세요: ");
        this.player = new Player(StandardInput.readLine());
    }

    public List<BaseBallNumber> playerInputNumbers() {
        return this.player.inputNumbers().numbers();
    }

    public List<BaseBallNumber> computerResultNumbers() {
        return this.computer.resultNumbers().numbers();
    }

    public boolean playable() {
        return this.command.playable();
    }
}
