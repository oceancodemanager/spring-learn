package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;

public class MDPlayer {
	private CompactDisc cd;

	@Autowired
	public MDPlayer(CompactDisc cd) {
		this.cd = cd;
	}

	public void play() {
		cd.play();
	}

}
