package model;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import databean.Photo;

/**
 * Reference : http://java4ever.blogspot.com/2008/08/play-with-flickr-api-in-java.html
 */

public class GetFlickr {
	/**
	 * @param args
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	static String apiKey = "d4880b71f9ca077ccb5e79606629532f";
	String secret = "ece3cc7d27329068";
	static String method = "flickr.photos.search";

	public static ArrayList<Photo> getPhotos(String keyword, int count)
			throws MalformedURLException, IOException, XMLStreamException {
		ArrayList<Photo> result = new ArrayList<Photo>();
		// &min_date_taken=2000-00-00&has_geo=1
		// &tag_mode=all&accuracy=11
		String[] keywords = keyword.split(" ");
		if (keywords.length > 0) {
			StringBuilder sb = new StringBuilder();
			for (String s : keywords) {
				sb.append(s);
				sb.append("+");
			}
			keyword = new String(sb);
		}
		URLConnection uc = new URL(
				"https://api.flickr.com/services/rest/?method=" + method
						+ "&api_key=" + apiKey + "&per_page=" + count
						+ "&text=" + keyword + "food" 
						+ "&tag_mode=all&content_type=1&sort=relevance")
				.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("result.xml")));
		String nextline;
		String[] servers = new String[count];
		String[] ids = new String[count];
		String[] secrets = new String[count];
		String[] titles = new String[count];
		while ((nextline = br.readLine()) != null) {
			System.out.println(nextline);
			bw.write(nextline);// fastest the way to read and write
		}
		br.close();
		bw.close();

		String filename = "result.xml";
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLEventReader r = factory.createXMLEventReader(filename, new FileInputStream(filename));
		int i = -1;
		while (r.hasNext()) {
			XMLEvent event = r.nextEvent();
			if (event.isStartElement()) {
				StartElement element = (StartElement) event;
				String elementName = element.getName().toString();

				if (elementName.equals("photo")) {// xml element starts with
												  // photo
					i++;
					Iterator iterator = element.getAttributes();

					while (iterator.hasNext()) {
						Attribute attribute = (Attribute) iterator.next();
						QName name = attribute.getName();
						String value = attribute.getValue();
						if ((name.toString()).equals("server")) {
							servers[i] = value;
						}
						if ((name.toString()).equals("id")) {
							ids[i] = value;
						}
						if ((name.toString()).equals("secret")) {
							secrets[i] = value;
						}
						if ((name.toString()).equals("title")) {
							titles[i] = value;
						}
					}
				}
			}
		}
		for (int j = 0; j < i; j++) {
			String flickrurl = "http://static.flickr.com/" + servers[j] + "/"
					+ ids[j] + "_" + secrets[j] + ".jpg";
			Photo pb = new Photo();
			pb.setUrl(flickrurl);
			pb.setTitle(titles[j]);
			result.add(pb);
		}
		return result;
	}

}
