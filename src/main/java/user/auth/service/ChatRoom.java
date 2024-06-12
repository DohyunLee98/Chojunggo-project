package user.auth.service;

public class ChatRoom {

	private String channelKey;
	private String title;

	public ChatRoom(String channelKey, String title) {
		super();
		this.channelKey = channelKey;
		this.title = title;
	}

	public String getChannelKey() {
		return channelKey;
	}

	public String getTitle() {
		return title;
	}

}
