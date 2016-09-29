package action;

import entity.TMusicdiscover;
import service.IMusicdiscoverService;
import org.springframework.context.ApplicationContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MusicdiscoverAction extends ActionSupport {
	private IMusicdiscoverService musicdiscoverService = null;
	private TMusicdiscover music = new TMusicdiscover();

	public String getSong() throws Exception {
		music = musicdiscoverService.findByUid(1);
		return SUCCESS;
	}

	public TMusicdiscover getMusic() {
		return music;
	}

	public void setMusic(TMusicdiscover music) {
		this.music = music;
	}

	public void setMusicdiscoverService(
			IMusicdiscoverService musicdiscoverService) {
		this.musicdiscoverService = musicdiscoverService;
	}
}
