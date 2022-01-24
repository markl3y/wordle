import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

//This is a six-letter Wordle game using a java terminal!
//Created by Tye Bosh. Have fun!

public class Wordle {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String[] WORD_LIBRARY = {"abduct", "abhors", "abides", "abject", "abjure", "abodes", "aborts", "abound", "abrupt", "absent", "absurd", "abused", "abuser", "acetyl", "aching", "acorns", "acting", "action", "active", "actors", "acuity", "acumen", "adepts", "adjoin", "adjust", "admire", "admits", "adobes", "adopts", "adores", "adorns", "adrift", "adroit", "adsorb", "adults", "advent", "adverb", "advert", "advice", "advise", "adzuki", "afield", "afresh", "ageism", "agency", "agents", "agouti", "aiders", "airmen", "albedo", "albeit", "albino", "albite", "albums", "alcove", "alders", "alerts", "aliens", "alight", "aligns", "alkyds", "almond", "almost", "alpine", "alters", "alumni", "ambers", "ambled", "ambles", "ambush", "amends", "amicus", "amidst", "amines", "amount", "amours", "ampler", "ampule", "amulet", "amused", "anchor", "anemic", "angels", "angers", "angled", "angler", "angles", "angsty", "animus", "ankles", "anklet", "anodes", "anodic", "anoles", "anomie", "anoxic", "answer", "anthem", "anther", "antics", "antler", "antrum", "anvils", "anyhow", "aorist", "aortic", "aphids", "apices", "aplomb", "apneic", "aprons", "arched", "arches", "archly", "ardent", "argent", "argued", "argues", "argyle", "aright", "arisen", "armful", "armies", "arming", "armlet", "armpit", "around", "arouse", "artful", "ascend", "ascent", "ashore", "asking", "aspect", "aspire", "astern", "asylum", "atomic", "atopic", "atrium", "audios", "audits", "augers", "auntie", "author", "autism", "auxins", "averts", "avidly", "avoids", "avowed", "awhile", "awoken", "axioms", "axions", "backed", "backer", "backup", "bacons", "badger", "badges", "bagels", "bagmen", "bailed", "bailer", "bairns", "baited", "baiter", "bakers", "bakery", "baking", "balder", "balers", "baling", "balked", "bander", "bandit", "banged", "banger", "bangle", "banish", "banjos", "banked", "banker", "banter", "bardic", "barely", "barest", "barfed", "barged", "barges", "baring", "barite", "barium", "barked", "barley", "barons", "barony", "barque", "baryon", "basely", "bashed", "basher", "basing", "basked", "basket", "basque", "basted", "baster", "bathed", "bather", "bathes", "bathos", "batiks", "batons", "bawled", "baying", "beachy", "beacon", "beards", "beauty", "beckon", "bedlam", "bedpan", "bedsit", "befits", "begins", "behalf", "behind", "behold", "beings", "belfry", "belong", "beluga", "bemoan", "berlin", "berths", "bestir", "bestow", "betray", "bewail", "beyond", "bhakti", "biased", "biceps", "bicker", "bidets", "bifold", "bigamy", "bigots", "bikers", "bilges", "bilked", "binary", "binder", "binged", "binges", "biogas", "biomes", "biopsy", "biotas", "bipeds", "births", "bisect", "bishop", "bisque", "bistro", "bitchy", "biters", "bitmap", "blacks", "blader", "blades", "blamed", "blames", "blanch", "blanks", "blared", "blares", "blazed", "blazer", "blazes", "blazon", "bleach", "bleary", "bleats", "blends", "blight", "blimey", "blimps", "blinds", "blinks", "blithe", "blocks", "blocky", "blokes", "blonde", "blonds", "blotch", "blouse", "blousy", "blowed", "blower", "blowup", "bluesy", "bluing", "bluish", "blunts", "blurts", "boards", "boated", "boater", "bodega", "bodice", "bodies", "bodily", "boding", "bodkin", "bogeys", "bogies", "boiled", "boiler", "bolder", "bolted", "boners", "bonier", "bonked", "bonsai", "borage", "borate", "boreal", "boring", "botany", "bother", "boucle", "boudin", "boughs", "bought", "bougie", "boules", "bounce", "bouncy", "bounds", "bounty", "bourne", "bourse", "bovine", "bowels", "bowers", "bowery", "bowing", "bowled", "bowler", "bowman", "bowmen", "boxcar", "boxers", "boxier", "boxing", "boyars", "boyish", "braced", "braces", "bracts", "braids", "brains", "brainy", "braise", "braked", "brakes", "branch", "brands", "brandy", "braved", "braves", "bravos", "brawls", "brawns", "brawny", "brayed", "brazed", "brazen", "brazil", "breach", "breads", "bready", "breaks", "breast", "breath", "bricks", "bridal", "brides", "bridge", "bridle", "briefs", "bright", "brined", "brines", "brings", "brinks", "broach", "broads", "brogue", "broils", "broken", "broncs", "bronze", "bronzy", "broths", "browns", "browse", "bruins", "bruise", "brunch", "brushy", "brutal", "brutes", "bucked", "bucket", "buckle", "budget", "budgie", "bugler", "bugles", "builds", "bulged", "bulges", "bulked", "bumped", "bumper", "bundle", "bungle", "bunked", "bunker", "bunted", "buoyed", "burden", "burgle", "burial", "buried", "buries", "burkas", "burlap", "burley", "burned", "burnet", "burped", "burqas", "burton", "bushed", "bushel", "busied", "busier", "busily", "busing", "busker", "busted", "buster", "bustle", "butane", "butler", "buyers", "buying", "bygone", "bylaws", "byline", "byword", "cabins", "cabled", "cables", "cadets", "cadres", "cairns", "caking", "caliph", "calmed", "calmer", "calved", "calves", "camber", "camels", "cameos", "camped", "camper", "campos", "campus", "candle", "candor", "canids", "canker", "canoed", "canoes", "canopy", "canted", "canter", "cantor", "cantos", "capers", "capful", "capons", "capsid", "captor", "carbon", "carbos", "carboy", "cardio", "cargos", "caries", "caring", "carney", "carols", "caroms", "carped", "carpel", "carpet", "carted", "cartel", "carton", "carved", "carves", "casein", "cashed", "cashew", "casing", "casino", "casket", "casque", "caster", "castle", "castor", "caters", "cation", "catkin", "catnip", "catsup", "caught", "caused", "cavern", "cavils", "caving", "cavity", "cavort", "cedars", "ceding", "censor", "cerium", "cervix", "cesium", "chador", "chafed", "chafes", "chains", "chairs", "chaise", "chalet", "chalks", "chalky", "champs", "change", "chants", "chapel", "charge", "charms", "charts", "chased", "chaser", "chaste", "cheapo", "cheats", "cherub", "chesty", "chiasm", "chides", "chiefs", "chiles", "chimed", "chimes", "chimps", "chinas", "chines", "chords", "chorus", "chosen", "chrome", "chunks", "cinema", "citrus", "claims", "clause", "client", "closed", "closer", "closet", "clouds", "coated", "coding", "colder", "column", "combat", "comedy", "coming", "comply", "convey", "copied", "copies", "costly", "counts", "county", "couple", "course", "courts", "cousin", "covers", "crafts", "creams", "creamy", "credit", "crimes", "crowds", "cruise", "crying", "curved", "curves", "custom", "dancer", "danger", "danish", "dating", "deaths", "debris", "delays", "demons", "denial", "dental", "depart", "deploy", "depths", "deputy", "design", "detail", "devils", "dialog", "direct", "domain", "donate", "dosage", "double", "doubts", "dozens", "dragon", "dreams", "drinks", "driven", "drives", "drones", "drying", "during", "duties", "easily", "eating", "editor", "emails", "employ", "enjoys", "enough", "equals", "equity", "ethics", "ethnic", "exotic", "expand", "export", "extras", "fabric", "facing", "factor", "failed", "fairly", "family", "famous", "faster", "father", "faults", "faulty", "favour", "felony", "fibers", "fields", "fights", "figure", "filmed", "filter", "finale", "finals", "finely", "finest", "finger", "firmly", "fiscal", "flames", "flavor", "flawed", "flight", "flower", "fluids", "flyers", "flying", "folder", "forced", "forces", "forest", "forget", "formal", "format", "formed", "forums", "foster", "fought", "fourth", "frames", "french", "fridge", "friend", "fringe", "frozen", "fruits", "fusion", "gained", "gamers", "garden", "garlic", "gather", "genius", "gently", "german", "giants", "gifted", "glance", "glands", "gloves", "gluten", "golden", "gospel", "govern", "grades", "grains", "grants", "grapes", "graphs", "gravel", "graves", "ground", "groups", "growth", "guards", "guides", "guilty", "guitar", "habits", "handle", "hardly", "hatred", "having", "hearts", "herbal", "heroic", "heroin", "hockey", "holder", "honest", "hoping", "hosted", "hotels", "hourly", "housed", "hugely", "humane", "humans", "humble", "hunger", "hungry", "hunter", "hybrid", "ideals", "ignore", "images", "impact", "import", "impose", "inches", "income", "induce", "inform", "injury", "inputs", "insect", "insert", "insure", "intake", "invest", "island", "itself", "jacket", "joined", "joints", "judges", "juices", "jumped", "jungle", "junior", "kidney", "kindle", "kindly", "knight", "knives", "labour", "lacked", "ladies", "lasted", "laughs", "launch", "lawyer", "layers", "laying", "layout", "learns", "learnt", "legacy", "legion", "length", "lifted", "lights", "linear", "lineup", "linked", "liquor", "listed", "listen", "locate", "locked", "locker", "longer", "losing", "lounge", "lovers", "loving", "lowest", "lumber", "lyrics", "magnet", "mailed", "mainly", "majors", "makers", "makeup", "making", "marble", "margin", "marine", "marked", "market", "marvel", "master", "matrix", "mature", "medals", "median", "melody", "mental", "mentor", "merits", "metals", "method", "metric", "mighty", "miners", "minors", "minute", "misery", "mobile", "models", "modern", "modest", "modify", "module", "monkey", "months", "mostly", "mother", "mounts", "movies", "moving", "muscle", "myriad", "myself", "namely", "native", "nature", "nearby", "nearly", "neatly", "nicely", "nickel", "nights", "normal", "notice", "notify", "novels", "novice", "number", "object", "obtain", "oceans", "oldest", "openly", "optics", "oracle", "orange", "organs", "ounces", "overly", "owners", "oxygen", "packed", "packet", "paired", "panels", "pantry", "parcel", "parent", "parish", "parked", "parole", "partly", "pastor", "pastry", "patrol", "patron", "paying", "peanut", "pedals", "pencil", "period", "permit", "person", "petrol", "phones", "phrase", "picked", "pilots", "pirate", "pistol", "piston", "pixels", "placed", "places", "plains", "planes", "planet", "plants", "plaque", "plates", "played", "player", "plenty", "pocket", "podium", "poetry", "points", "police", "policy", "polish", "polite", "portal", "postal", "posted", "poster", "pounds", "poured", "powder", "powers", "praise", "priced", "prices", "pricey", "priest", "prince", "prints", "prison", "prizes", "profit", "proved", "proven", "proves", "public", "punish", "purely", "purity", "pushed", "python", "quartz", "quirky", "quoted", "quotes", "racing", "racism", "racist", "radius", "raised", "random", "ranged", "ranges", "ranked", "rating", "ratios", "reason", "refund", "regain", "region", "remain", "remind", "rental", "result", "retail", "retain", "rifles", "rights", "ritual", "rivals", "robust", "rocket", "romans", "rounds", "routes", "ruined", "ruling", "runway", "rushed", "rustic", "sacred", "safely", "safety", "salmon", "sample", "saving", "saying", "scared", "scored", "script", "search", "second", "sector", "seldom", "senior", "serial", "sewing", "sexual", "shadow", "shaped", "shared", "shield", "should", "showed", "shower", "shrimp", "shrink", "signal", "signed", "silent", "silver", "simple", "simply", "singer", "single", "sketch", "slider", "slight", "slowed", "slower", "smiled", "social", "socket", "sodium", "softer", "solved", "sorted", "sought", "source", "soviet", "spider", "spinal", "spoken", "sponge", "spread", "spring", "sprint", "square", "stable", "stance", "staple", "stayed", "steady", "sticky", "stolen", "stored", "strain", "streak", "stream", "strike", "string", "strive", "stroke", "strong", "struck", "studio", "stupid", "sturdy", "submit", "subtle", "subway", "sucked", "suited", "superb", "surely", "survey", "switch", "symbol", "syntax", "tables", "tackle", "taking", "talked", "thanks", "theirs", "theory", "things", "thinks", "thread", "thrive", "throne", "thrown", "throws", "tigers", "timber", "timely", "tokens", "tongue", "topics", "torque", "toward", "towels", "towers", "toxins", "traced", "tracks", "trades", "tragic", "trails", "trains", "travel", "trends", "trendy", "trials", "tribal", "tribes", "tricks", "tricky", "triple", "trophy", "trucks", "trying", "tubing", "tucked", "tumors", "turkey", "turned", "typing", "unable", "unfair", "united", "unlike", "unlock", "unpaid", "unsafe", "update", "upload", "upside", "upward", "urgent", "usable", "valued", "values", "vanity", "varied", "varies", "vastly", "vector", "vendor", "verbal", "verify", "viable", "videos", "virtue", "visual", "voices", "volume", "voters", "voting", "voyage", "waited", "waiver", "waking", "walked", "walnut", "wander", "wanted", "warmth", "warned", "washed", "washer", "wasted", "waters", "wealth", "weapon", "weighs", "weight", "whales", "whilst", "whites", "wicked", "widely", "widget", "winter", "wisdom", "wisely", "wished", "wizard", "wolves", "wonder", "worked", "worlds", "worthy", "wounds", "writes", "yields", "yogurt", "zombie"};

    public static void main(String[] args) {
        String wordOfTheDay = WORD_LIBRARY[acquireIndex()];
        welcomeUser();
        if (checkYesNo()) {
            tutorial();
        }
        int playerScore = wordle(wordOfTheDay);
        System.out.println("\nCongratulations! You found today's Wordle!\n");
        System.out.println("You took " + playerScore + " guesses!\n");
        System.out.println("See you tomorrow for a different word!\n\nGoodbye!\n");
    }

    static void welcomeUser() {
        System.out.println("Hello and welcome to Cincy 13's daily 6-letter Wordle!\n");
        System.out.println("Is this your first time?\n");
    }

    static int acquireIndex() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        String dateString = formatter.format(date);
        int dateInt = Integer.parseInt(dateString);
        Random random = new Random(dateInt);
        return random.nextInt(1248);
    }
    static boolean checkYesNo() {
        Scanner userInput = new Scanner(System.in);
        String yorN;
        do {
            System.out.print("(Y)es or (N)o? : ");
            yorN = userInput.next();
            if (!yorN.equals("Y") && !yorN.equals("N")) {
                System.out.print("Unrecognized input.\n");
            }
        } while (!yorN.equals("Y") && !yorN.equals("N"));
        return yorN.equals("Y");
    }
    static void tutorial() {
        System.out.print("\n\nWelcome to Wordle! The game is simple: type any combination\n");
        System.out.println("of six letters, and see if you've guessed the word of the day!");
        System.out.println("When your letter doesn't appear in the word, it will be shown");
        System.out.println("in the display in " + ANSI_RED + "red" + ANSI_RESET + ". If you have the right letter");
        System.out.println("in the wrong place, it will be shown in the display in " + ANSI_YELLOW + "yellow" + ANSI_RESET + ".");
        System.out.println("If you have the right letter in the right spot, it will be " + ANSI_GREEN + "green" + ANSI_RESET + "!");
        System.out.println("(NOTE: No word will have repeated letters, i.e. \"ladder\" or \"stylus\")");
        System.out.println("That's all there is to it. Once you find the word, your guess count");
        System.out.println("total will be displayed. Have fun!\n");
    }
    static int wordle(String wordOfTheDay) {
        int turnCounter = 0;
        wordOfTheDay = wordOfTheDay.toUpperCase();
        System.out.println("\nToday's word: [?][?][?][?][?][?]\n");
        String userWord;
        char[] wordOfTheDayChars = wordOfTheDay.toCharArray();
        String[] headsUpDisplay = new String[6];
        do {
            userWord = guessedWord();
            char[] userWordChars = userWord.toCharArray();
            for (int i = 0; i < userWordChars.length; i++) {
                if (userWordChars[i] == wordOfTheDayChars[i]) {
                    headsUpDisplay[i] = "[" + ANSI_GREEN + wordOfTheDayChars[i] + ANSI_RESET + "]";
                } else if (new String(wordOfTheDayChars).contains(Character.toString(userWordChars[i]))) {
                    headsUpDisplay[i] = "[" + ANSI_YELLOW + userWordChars[i] + ANSI_RESET + "]";
                } else {
                    headsUpDisplay[i] = "[" + ANSI_RED + userWordChars[i] + ANSI_RESET + "]";
                }
            }
            updateDisplay(headsUpDisplay);

            turnCounter++;
        } while (!userWord.equals(wordOfTheDay));
        return turnCounter;
    }

    private static void promptUser1() {
        System.out.print("Please enter your six letter guess: ");
    }

    private static String guessedWord() {
        Scanner userInput = new Scanner(System.in);
        String userWord;
        do {
            promptUser1();
            userWord = userInput.nextLine();
            userWord = userWord.toUpperCase();
            if (userWord.length() != 6) {
                System.out.print("\nThis is not a six letter guess.\n\n");
            }
        } while (userWord.length() != 6);
        return userWord;
    }

    private static void updateDisplay(String[] headsUp) {
        System.out.print("\nToday's word: ");
        for (String s : headsUp) {
            System.out.print(s);
        }
        System.out.println("\n");
    }
}
