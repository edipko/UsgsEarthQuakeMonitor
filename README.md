# UsgsEarthQuakeMonitor
Nagios plugin to monitor uses the USGS geoJSON feeds to alert when there is an earthquake.
<br/>
<br/>
After packaging this into a jar file, use the following process to make the command executable:
<br/>
<b>cat stub.sh UsgsQuakeMonitor.jar > UsgsQuakeMonitor && chmod +x UsgsQuakeMonitor</b>
<br/>
<br/>
This plugin expects to use the USGS geoJSON feeds located here:
http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/significant_day.geojson
<br/>or<br/>
http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/significant_hour.geojson

The plugin accepts command line options:<br/>
-v [1|2]  - set verbosity<br/>
-help     - Display plugin help<br/>
Specifying a URL is a requirment<br/>
<br/>
The nagios command should look similar to this:<br/>
<b>UsgsQuakeMonitor -v 1 http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/significant_hour.geojson</b>