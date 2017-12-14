package soundsystem;

import org.springframework.stereotype.Component;

@Component
public class RockPeppers implements CompactDisc {

	private String title = "rock";
	private String artist = "The rock stone";

	@Override
	public void play() {
		System.out.println("Playing " + title + " by " + artist);
	}

}
