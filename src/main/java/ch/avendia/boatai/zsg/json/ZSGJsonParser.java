package ch.avendia.boatai.zsg.json;

import java.io.Reader;

import com.google.gson.Gson;

public class ZSGJsonParser {

	public ZSGShips parse(Reader reader) {

		Gson gson = new Gson();
		ZSGShips zsgShips = gson.fromJson(reader, ZSGShips.class);

		return zsgShips;
	}

}
