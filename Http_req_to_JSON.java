//The return is a String JSONreponse
public String readJSON(String str_containing_url){
//if url is null, don't make the http request (obviously)
URL url;
try{url = URL(str_containing_url);} // Here you should handle a MalformedURLException exception
catch(MalformedURLException exception){Log.e("MainActivity","There is a malformedurlexception");}
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
}