package ch.avendia.boatai.rawlake;

import java.awt.Point;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ch.avendia.boatai.rawlake.json.JsonLakes;
import ch.avendia.boatai.rawlake.json.Transform;

import com.google.gson.Gson;

public class LakeFactory {

	private static LakeFactory instance;
	private Map<String, RawLake> lakes;

	private LakeFactory() {
		lakes = new HashMap<String, RawLake>();
	}

	public static LakeFactory getInstance() {
		if (instance == null) {
			synchronized (LakeFactory.class) {
				if (instance == null) {
					instance = new LakeFactory();
				}
			}
		}

		return instance;
	}

	public void parseJson(Reader reader) {

		Gson gson = new Gson();
		JsonLakes jsonLakes = gson.fromJson(reader, JsonLakes.class);

		Transform transform = jsonLakes.getTransform();
		double scaleX = transform.getScale().get(0);
		double scaleY = transform.getScale().get(1);
		double translateX = transform.getTranslate().get(0);
		double translateY = transform.getTranslate().get(1);

		jsonLakes.getObjects().getLakes().getGeometries().forEach(g -> {
			RawLake rawLake = new RawLake(g.getProperties().getName());
			System.out.println("Generating " + g.getProperties().getName() + " lake...");
			for (int index : g.getArcs().get(0)) {
				List<Point.Double> polygonLake = new ArrayList<Point.Double>();
				int x = 0, y = 0;
				for (List<Integer> coord : jsonLakes.getArcs().get(index)) {
					// for (List<Integer> coord : jsonLakes.getArcs().get((index * -1) - 1)) {

				Point.Double coordinate = new Point.Double((x += coord.get(0)) * scaleX + translateX, (y += coord.get(1)) * scaleY + translateY);
				polygonLake.add(coordinate);
			}
			rawLake.addPolygonLake(polygonLake);
		}
		lakes.put(rawLake.getName(), rawLake);
	}	);

	}

	public RawLake getRawLake(String name) {
		return lakes.get(name);
	}
}
