package main;

import java.util.ArrayList;

public class MessageBDD {

	public static ArrayList<MessageBean> mesArray = new ArrayList<>();

	public static void main(String[] args) {
		ArrayList<MessageBean> mesArray = new ArrayList<>();
		getMessage(mesArray);
		addMessage(new MessageBean("bill", "john is a weirdo"));
	}

	public static MessageBean getMessage(ArrayList<MessageBean> mesArray) {

		if (mesArray == null) {
			return null;
		}
		MessageBean message = null;
		for (int i = 0; i < mesArray.size(); i++) {
			if (message == null) {
				message = mesArray.get(i);
			}

		}
		return message;
	}

	static void addMessage(MessageBean message) {
		mesArray.add(message);
		System.out.println("Le message a �t� ajouter");
	}

}
