package ch.avendia.boatai.zsg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class ZSGAPI {

	public String getJson() {
		try {
			URI url = new URI("http://map.zsg.ch/positions");

			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet httpget = new HttpGet(url);
			HttpResponse response;

			response = httpClient.execute(httpget);

			HttpEntity entity = response.getEntity();
			if (entity != null) {
				long len = entity.getContentLength();
				InputStream inputStream = entity.getContent();
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

				StringBuilder sb = new StringBuilder();
				String read = reader.readLine();

				while (read != null) {
					sb.append(read);
					read = reader.readLine();
				}

				return sb.toString();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// Should never happen
			e.printStackTrace();
		}

		return null;

	}
}
