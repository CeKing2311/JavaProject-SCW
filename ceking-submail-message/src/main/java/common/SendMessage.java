package common;

import config.AppConfig;
import lib.MessageSend;
import utils.ConfigLoader;

public class SendMessage {

	AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Message);
	MessageSend submail = new MessageSend(config);

	public String sendMessage(String mobile, String content) {

		submail.addTo(mobile);
		submail.addContent(content);
		String result = submail.send();
		return result;
	}
}