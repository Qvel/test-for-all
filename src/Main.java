import composition.Car;
import test.Facade;


import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;


public class Main {

    private static final BigInteger INTERFACE_LV_ID = BigInteger.valueOf(13L);
    private static final BigInteger E1_LV_ID = BigInteger.valueOf(13013L);
    private static final BigInteger DS1_LV_ID = BigInteger.valueOf(13001L);
    private static final BigInteger STM1_LV_ID = BigInteger.valueOf(1091558029013653629L);
    private static final BigInteger OC3_LV_ID = BigInteger.valueOf(13004L);

    public static void main(String[] args) throws UnsupportedEncodingException, CloneNotSupportedException {

        List<BigInteger> toString = List.of(BigInteger.ONE,BigInteger.TWO);
        System.out.println(toString);


        Map<String , String > hashMap = new HashMap<>();
        hashMap.put("1","one");
        hashMap.put("2","two");

        System.out.println(hashMap.get("1"));

        System.out.println("*************");
        for(Map.Entry<String,String> variable : hashMap.entrySet() ){
            System.out.println(variable.getKey());
            System.out.println(variable.getValue());
        }

        hashMap.forEach(
                (k,v) -> {
                    System.out.println("Key" + k);
                    System.out.println("value" + v);
        }

        );
        System.out.println("End of Collections *******");
        Predicate<Integer> five = (x) -> x>5;
        System.out.println(five.test(3));
        boolean result = five.test(3);
        System.out.println(result);
        List<String> values;

         var a = List.of("1","2","3");
        a.forEach(System.out::println);

        List<String> b = new ArrayList<>();
        b.add("1");
        b.add("2");
        b.add("3");
        for(String d : b){
            System.out.println(d);
        }

        values = Stream.of("mama","papa").map(String::toUpperCase).collect(toCollection(ArrayList::new));
        values.forEach(System.out::println);

        Optional<String> hello;

        UnaryOperator<Optional<String>> test = x -> x.isPresent() ? Optional.of("Correct") : Optional.of("Was null");
        hello = test.apply(Optional.empty());

        System.out.println(hello.get());


        List<Integer> newOp = Stream.of("1","2","3").map(
                Integer::new
        ).collect(toCollection(ArrayList::new));

        List<Car> cars = Stream.of("1","2","3").filter(
                                  x -> Integer.valueOf(x).equals(1)
                            ).map(
                                   Car::new

                            ).collect(toCollection(ArrayList::new));

        cars.forEach(System.out::println);


        Stream.of(1, 2, 3).max(Comparator.comparing(x -> x));

        newOp.parallelStream();


        /*
        String a = "Thats a nice joke ??? ?";
        System.out.println(a);
        //mysqlSafe(a);
        System.out.println(mysqlSafe(a));
        */
        /*
        String date = "2018-03-01T21:00:00+0200";
        date = date.split("T")[0] + "  " + date.split("T")[1].substring(0,5);
        System.out.println(date);
        */
        /*
        String email = "iamquel08@gmail.com";
        Pattern pattern = Pattern.compile("^(\\w+)@([a-z]+)\\.([a-z]{2,4})$");
        Matcher matcher = pattern.matcher(email);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
        List<String> animals = new ArrayList<>();
        List<String> cats = new ArrayList<>();
        animals.add("cat");
        animals.add("dog");
        animals.add("cow");
        animals.forEach(animal -> {
            if(Objects.equals(animal, "cat")){
                cats.add(animal);
            }
        });
        cats.forEach(System.out::println);




        /*
        String pattern = "[a-z]+";
        String text = "32 kbps";
        Pattern p = Pattern.compile("[a-z]+");
        Matcher m = p.matcher(text);
        String serviceSpeedMbps = "";
        while(m.find()) {
           // System.out.print(text.substring(m.start(), m.end()));
            serviceSpeedMbps = m.group();
        }
        System.out.println(serviceSpeedMbps);
        */
        /*
        String serviceSpeedInput = "35Mbps";
        //35Mbps
        //32 kbps
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(serviceSpeedInput);
        String serviceSpeedMbps = "";

        while (matcher.find()) {
            serviceSpeedMbps = matcher.group();
        }
        int serviceSpeedMbpsInt = Integer.parseInt(serviceSpeedMbps);
        int bandwidthKbps;
        pattern = Pattern.compile("[a-z]+");
        matcher = pattern.matcher(serviceSpeedInput);
        String serviceSpeed = "";
        while (matcher.find()) {
            serviceSpeed = matcher.group();
        }
        if(Objects.equals(serviceSpeed, "kbps")){
            System.out.println("We have kbps value");
            bandwidthKbps = serviceSpeedMbpsInt;
            System.out.println("bandwidthKbps : {} , " + bandwidthKbps);
        }else{
            System.out.println("serviceSpeedMbps : {} , " + serviceSpeedMbps);
            bandwidthKbps = serviceSpeedMbpsInt * 1000;
            System.out.println("bandwidthKbps : {} , " + bandwidthKbps);
        }
        */
        /*
        String a = "3";

        if(Objects.equals(a, "3")){
            a = "5";
        }else{
            a = "4";
        }

        if(Objects.equals(a, "5")){
            System.out.println("Hello");
        }
        */
        /*
        List<BigInteger> device = new ArrayList<>();
        device.add(BigInteger.ONE);
        device.add(BigInteger.valueOf(2L));
        device.add(BigInteger.valueOf(3L));
        device.add(BigInteger.valueOf(4L));
        device.add(null);
        device.add(null);
        device.add(null);
        device.add(null);
        BigInteger result = null;
        for(BigInteger devices : device){
            if(devices != null){
                result = devices;
            }
        }
        System.out.println(result);
        boolean res = true;
        while(res) {
            for (BigInteger devices : device) {
                if (devices != null) {
                    System.out.println(devices);
                }
                if (devices == null) {
                    res = false;
                }
            }
        }
        */
        /*
        BigInteger convertedPriority = BigInteger.valueOf(5L);
        BigInteger [] [] devices = new BigInteger[2][2];
        devices[0][0] =  BigInteger.valueOf(2L);
        devices[0][1] =  BigInteger.valueOf(3L);
        devices[1][0] =  BigInteger.valueOf(4L);
        devices[1][1] =  BigInteger.valueOf(5L);
        BigInteger result = null;
        for (BigInteger[] device : devices) {
            if (Objects.equals(device[1], convertedPriority)) {
                result = device[0];
            }
        }
        System.out.println(result);
        */
        //System.out.println(getNewIpAddressIncrement("192.168.2.1",1));
        /*
        List<String> namesForException = new ArrayList<>();
        namesForException.add("Serj");
        namesForException.add("Vlad");
        namesForException.add("Max");
        String namesOfLinks = "";
        for(String nameELEx : namesForException){
            namesOfLinks += nameELEx + " ";
        }
        System.out.println(namesOfLinks);
        */
        /*
        String REGESTRATION_TEMPLATE = "<h3 style='color:red' >Hello World!</h3>"+
                                       "<a href=0> link one</a>"+
                                       "<a href=1> link two</a>";
        List<String> links = new ArrayList<>();
        links.add("'http://hiQvel/dadasdasda'");
        links.add("'http://helloQvel/aababa'");
        System.out.println(setLinksIntoMessage(REGESTRATION_TEMPLATE,links));
        */

        /*
        String ipAddress = "115.42.150.37";
        String ipAddressDec = "10.0.0.0";
        ipAddress = getNewIpAddressIncrement(ipAddress,1);
        System.out.println("In " + ipAddress);
        ipAddressDec = getNewIpAddressDecrement(ipAddressDec,1);
        System.out.println("Dec " + ipAddressDec);
        String IP_ADDRESS_PATTERN = "/^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/";

        Pattern pattern = Pattern.compile(IP_ADDRESS_PATTERN);
        Matcher m = pattern.matcher(ipAddress);
        boolean b = m.matches();

        System.out.println(b);
        */
        /*
        Burger burger = (new BurgerBuilder(3).build());
        System.out.println(burger);

        Burger burger1 = (new BurgerBuilder(4).addCheese().addPaperony().addTomato().build());
        System.out.println(burger1);
        */
        /*
        Ship ship1 = new Ship(3,"dolly");

        Ship clone = (Ship) ship1.clone();

        clone.setName("Sereja");

        System.out.println("class Dolly name = " + ship1.getName() + " prototype name = {}" + clone.getName());
        */
        /*
        Singleton singleton = Singleton.getInstance();
        singleton.sayHello();
           */
        /*
        HomeLion homeLion = new HomeLion();
        WildLion wildLion = new WildLion();
        DogAdapter dogAdapter = new DogAdapter(new Dog());
        LionHunter lionHunter = new LionHunter();
        lionHunter.hunt(homeLion);
        lionHunter.hunt(wildLion);
        lionHunter.hunt(dogAdapter);
        */

        /* Diplom try
       try {
           String status;
           Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
           List<NetworkInterface> allNetworkInterfaces = Collections.list(interfaces);
           System.out.println(allNetworkInterfaces.size());
           for(NetworkInterface network : allNetworkInterfaces){
               System.out.println("name : " + network.getName());
               System.out.println("****************************");
           }

           HashMap<String,String> networkInterfaces = new HashMap<String, String>();
           Enumeration<InetAddress> inetAddressEnumeration;
           String name ;
           for(NetworkInterface network : allNetworkInterfaces){
               name = network.getName();
               networkInterfaces.put("name : "  + name,network.getName());
               networkInterfaces.put("DisplayName :"  + name,network.getDisplayName());
               byte [] hardware = network.getHardwareAddress();

               if(network.isUp()){
                   status = "up";
                   networkInterfaces.put("Status: " + name,status);
               }else{
                   status = "off";
                   networkInterfaces.put("Status: " + name,status);
               }

               inetAddressEnumeration = network.getInetAddresses();
               List<InetAddress> inetAddresses = Collections.list(inetAddressEnumeration);
               for(InetAddress inetAddress : inetAddresses){
                   networkInterfaces.put("inetAddress getHostAddress :" + name,inetAddress.getHostAddress());
                   networkInterfaces.put("inetAddress getHostName:" + name,inetAddress.getHostName());
                   networkInterfaces.put("inetAddress getCanonicalHostName:" + name,inetAddress.getCanonicalHostName());
               }


           }
           System.out.println("Map size () " + networkInterfaces.size());
           for(Map.Entry<String,String> cookie : networkInterfaces.entrySet()){
               System.out.println("<p>"+cookie.getKey() + " " +cookie.getValue() +"</p>");
               System.out.println("****************************************************");
           }

        } catch (SocketException e) {
            e.printStackTrace();
        }
        String url = "https://www.google.com.ua";
        boolean available = false;
        HttpURLConnection connection = null;
        try {
            URL u = new URL(url);
            connection = (HttpURLConnection) u.openConnection();
            connection.connect();
            System.out.println("*********Input Stream********");
            InputStream inputStream = connection.getInputStream();
            System.out.println(getStringFromInputStream(inputStream));
            System.out.println(connection.getInputStream().toString());
            available = true;
        } catch (final IOException e) {

            available = false;
        }finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        System.out.println("Work Url");
        System.out.println(available);
        System.out.println("Ping URL");
        ping(url);

       List<String> name = new ArrayList<>();
       Set<String> namesConv = new HashSet<>();
       name.add("12");
       name.add("12");
       namesConv.addAll(name);
        System.out.println(namesConv.size());


    }

    private static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }

    private static void ping(String url){
        InetAddress address = null;
        try {
            address = InetAddress.getByName(new URL(url).getHost());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String ip = address.getHostAddress();

        String pingCmd = "ping " + ip;
        System.out.println(pingCmd);
        try {
            Runtime r = Runtime.getRuntime();
            Process p = r.exec(pingCmd);

            BufferedReader in = new BufferedReader(new
                    InputStreamReader(p.getInputStream(),"UTF-8"));

            String inputLine;
            System.out.println(in.readLine());
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        */
    }
    private static String getNewIpAddressIncrement (String value,int number){

        String [] ipAddressSplited = value.split("\\.");
        String ipAddress = "";
        Integer lastOctet = new Integer(ipAddressSplited[ipAddressSplited.length-1]);
        Integer newValueOfLastOctet = lastOctet + number;
        ipAddressSplited[3] = newValueOfLastOctet.toString();
        for(String ipAddressNew : ipAddressSplited){
            ipAddress+=ipAddressNew + ".";
        }
        ipAddress = ipAddress.substring(0, ipAddress.length() - 1);

        return ipAddress;
    }
    public static String mysqlSafe(String input) {
        if (input == null) return null;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (i < (input.length() - 1)) { // Emojis are two characters long in java, e.g. a rocket emoji is "\uD83D\uDE80";
                if (Character.isSurrogatePair(input.charAt(i), input.charAt(i + 1))) {
                    i += 1; //also skip the second character of the emoji
                    continue;
                }
            }
            sb.append(input.charAt(i));
        }

        return sb.toString();
    }


}
interface sizeCan<T>{
    default int size(T t){
        return t.toString().length();
    }
}

class B implements sizeCan{

}
