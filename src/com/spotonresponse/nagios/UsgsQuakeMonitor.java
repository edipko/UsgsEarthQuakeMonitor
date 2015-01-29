package com.spotonresponse.nagios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.spotonresponse.nagios.beans.Feature;
import com.spotonresponse.nagios.beans.GeoJson;
import com.spotonresponse.nagios.beans.Properties;

import static org.kohsuke.args4j.ExampleMode.ALL;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

public class UsgsQuakeMonitor {

	/*
	 * Proces the command line options using args4j
	 */
	@Option(name = "-v", usage = "Sets Verbosity")
	private int verbosity;

	@Option(name = "-help", usage = "Display usage information")
	private boolean help;

	// receives other command line parameters than options
	@Argument(required=true, metaVar="URL")
	private List<String> arguments = new ArrayList<String>();

	/*
	 * Method to get the JSON feed data
	 */
	private static String readUrl(String urlString) throws Exception {
		BufferedReader reader = null;
		try {
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1)
				buffer.append(chars, 0, read);

			return buffer.toString();
		} finally {
			if (reader != null)
				reader.close();
		}
	}

	public void doMain(String[] args) throws IOException {
		String output = "";
		String json = "";
		String output_simple = "";
		String output_detail = "";
		int exit_code = 0;

		CmdLineParser parser = new CmdLineParser(this);

		// if you have a wider console, you could increase the value;
		// here 80 is also the default
		parser.setUsageWidth(80);

		try {
			// parse the arguments.
			parser.parseArgument(args);

			// you can parse additional arguments if you want.
			// parser.parseArgument("more","args");

			// after parsing arguments, you should check
			// if enough arguments are given.
			if (arguments.isEmpty())
				throw new CmdLineException(parser, "No argument is given");

		} catch (CmdLineException e) {
			// if there's a problem in the command line,
			// you'll get this exception. this will report
			// an error message.
			System.err.println(e.getMessage());
			System.err.println("java JsonFeedCheck [options...] URL");
			// print the list of available options
			parser.printUsage(System.err);
			System.err.println();

			// print option sample. This is useful some time
			System.err.println("  Example: java JsonFeedCheck"
					+ parser.printExample(ALL));

			return;
		}

		/*
		 * If -help was specified, end
		 */
		if (help) {
			System.err.println("  Example: java JsonFeedCheck"
					+ parser.printExample(ALL));
			System.exit(1);
		}


		// Get the JSON output from the URL
		try {
			json = readUrl(arguments.get(0));

			/*
			 * Use Gson to parse the GeoJSON feed
			 */
			Gson gson = new Gson();
			GeoJson geojson = gson.fromJson(json, GeoJson.class);

			/*
			 * Determine if there are incidnets to process Count will be greater
			 * than 0, If so, get additional properties for the incident
			 */
			if (geojson.getMetadata().getCount() > 0) {
				List<Feature> features = geojson.getFeatures();
				Properties prop = features.get(0).getProperties();
				output_simple = "Earthquake: " + prop.getTitle();
				output_detail = "Earthquake: " + prop.getTitle() + "\n"
						+ "Magnitude: " + prop.getMag() + "\n" + "Place: "
						+ prop.getPlace() + "\n" + "Alert: " + prop.getAlert();

				/*
				 * Set the exit code based on the alert level
				 */
				if (prop.getAlert() == "green") {
					// Alert level, is green, so make this a warning
					exit_code = 1;
				} else {
					// Set Critical
					exit_code = 2;
				}
			} else {
				/*
				 * There are no incidents
				 */
				output_simple = "No Earthquakes";
				output_detail = "No Earthquakes";
				exit_code = 0;
			}

			switch (verbosity) {
			case 0:
				output = output_simple;
				break;
			case 1:
				output = output_detail;
				break;
			default:
				output = output_simple;
				break;
			}

			System.out.println(output);
			System.exit(exit_code);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws IOException {
		new UsgsQuakeMonitor().doMain(args);
	}

}
