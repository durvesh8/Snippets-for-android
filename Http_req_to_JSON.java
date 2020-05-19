//The return is a String JSONreponse
public String readJSON(String str_containing_url)
//if url is null, don't make the http request (obviously)
URL url = new URL(str_containing_url); // Here you can throw a MalformedURLException exception
HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
 urlConnection.setRequestMethod("GET");
//urlConnection.setReadTimeout(10000 /* milliseconds */);
//urlConnection.setConnectTimeout(15000 /* milliseconds */);
urlConnection.connect(); //Makes the connection (Until this line, we were just making the request)
if(urlConnection.getResponseCode()==200){//then only proceed
	InputStream inputStream = urlConnection.getInputStream();
	InputStreamReader inputStreamReader  = new InputStreamReader(inputStream,Charset.forName("UTF-8"));
	BufferedReader reader = new BufferedReader(inputStreamReader);
	StringBuilder output = new StringBuilder();
	String line = reader.readLine();
	while (line != null) {
		output.append(line);
		line = reader.readLine();
	}
	return output.toString();
}
else return "";