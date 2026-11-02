import library.MusicLibrary;
import model.PlayTime;
import model.Song;
import strategy.TitleSortStrategy;
import strategy.ArtistSortStrategy;
import strategy.DurationSortStrategy;
import java.util.List;
import reflection.ReflectionInspector;
import strategy.SortStrategy;

public class Main {
    public static void main(String[] args) {
        ReflectionInspector inspector = new ReflectionInspector();
        var songReport = inspector.inspect(Song.class);
        System.out.println("\nSong fields: " + songReport.fieldNames());
        System.out.println("Song fully encapsulated: " + songReport.allFieldsEncapsulated());
        System.out.println(inspector.describePatternRole(TitleSortStrategy.class));
        System.out.println("TitleSortStrategy implements SortStrategy: " +
                inspector.implementsInterface(new TitleSortStrategy(), SortStrategy.class));

        MusicLibrary library = new MusicLibrary();
        library.addSong(new Song("Shape of you", "Ed Sheeran", "Divide", "Pop",
                PlayTime.ofMinutesSeconds("4:24"), "The club isn't the best place to find a lover\\n\" +\n" +
                "                        \"So the bar is where I go (mm)\\n\" +\n" +
                "                        \"Me and my friends at the table doing shots\\n\" +\n" +
                "                        \"Drinking fast and then we talk slow (mm)\\n\" +\n" +
                "                        \"Come over and start up a conversation with just me\\n\" +\n" +
                "                        \"And trust me I'll give it a chance now (mm)\\n\" +\n" +
                "                        \"Take my hand, stop, put Van the Man on the jukebox\\n\" +\n" +
                "                        \"And then we start to dance, and now I'm singing like\\n\" +\n" +
                "                        \"Girl, you know I want your love\\n\" +\n" +
                "                        \"Your love was handmade for somebody like me\\n\" +\n" +
                "                        \"Come on now, follow my lead\\n\" +\n" +
                "                        \"I may be crazy, don't mind me\\n\" +\n" +
                "                        \"Say, boy, let's not talk too much\\n\" +\n" +
                "                        \"Grab on my waist and put that body on me\\n\" +\n" +
                "                        \"Come on now, follow my lead\\n\" +\n" +
                "                        \"Come, come on now, follow my lead, mm\\n\" +\n" +
                "                        \"I'm in love with the shape of you\\n\" +\n" +
                "                        \"We push and pull like a magnet do\\n\" +\n" +
                "                        \"Although my heart is falling too\\n\" +\n" +
                "                        \"I'm in love with your body\\n\" +\n" +
                "                        \"And last night you were in my room\\n\" +\n" +
                "                        \"And now my bedsheets smell like you\\n\" +\n" +
                "                        \"Every day discovering something brand new\\n\" +\n" +
                "                        \"I'm in love with your body\\n\" +\n" +
                "                        \"(Oh-I-oh-I-oh-I-oh-I)\\n\" +\n" +
                "                        \"I'm in love with your body\\n\" +\n" +
                "                        \"(Oh-I-oh-I-oh-I-oh-I)\\n\" +\n" +
                "                        \"I'm in love with your body\\n\" +\n" +
                "                        \"(Oh-I-oh-I-oh-I-oh-I)\\n\" +\n" +
                "                        \"I'm in love with your body\\n\" +\n" +
                "                        \"Every day discovering something brand new\\n\" +\n" +
                "                        \"I'm in love with the shape of you\\n\" +\n" +
                "                        \"One week in we let the story begin\\n\" +\n" +
                "                        \"We're going out on our first date (mm)\\n\" +\n" +
                "                        \"You and me are thrifty, so go all you can eat\\n\" +\n" +
                "                        \"Fill up your bag and I fill up a plate (mm)\\n\" +\n" +
                "                        \"We talk for hours and hours about the sweet and the sour\\n\" +\n" +
                "                        \"And how your family is doing okay (mm)\\n\" +\n" +
                "                        \"And leave and get in a taxi, then kiss in the backseat\\n\" +\n" +
                "                        \"Tell the driver make the radio play, and I'm singing like\\n\" +\n" +
                "                        \"Girl, you know I want your love\\n\" +\n" +
                "                        \"Your love was handmade for somebody like me\\n\" +\n" +
                "                        \"Come on now, follow my lead\\n\" +\n" +
                "                        \"I may be crazy, don't mind me\\n\" +\n" +
                "                        \"Say, boy, let's not talk too much\\n\" +\n" +
                "                        \"Grab on my waist and put that body on me\\n\" +\n" +
                "                        \"Come on now, follow my lead\\n\" +\n" +
                "                        \"Come, come on now, follow my lead, mm\\n\" +\n" +
                "                        \"I'm in love with the shape of you\\n\" +\n" +
                "                        \"We push and pull like a magnet do\\n\" +\n" +
                "                        \"Although my heart is falling too\\n\" +\n" +
                "                        \"I'm in love with your body\\n\" +\n" +
                "                        \"And last night you were in my room\\n\" +\n" +
                "                        \"And now my bedsheets smell like you\\n\" +\n" +
                "                        \"Every day discovering something brand new\\n\" +\n" +
                "                        \"I'm in love with your body\\n\" +\n" +
                "                        \"(Oh-I-oh-I-oh-I-oh-I)\\n\" +\n" +
                "                        \"I'm in love with your body\\n\" +\n" +
                "                        \"(Oh-I-oh-I-oh-I-oh-I)\\n\" +\n" +
                "                        \"I'm in love with your body\\n\" +\n" +
                "                        \"(Oh-I-oh-I-oh-I-oh-I)\\n\" +\n" +
                "                        \"I'm in love with your body\\n\" +\n" +
                "                        \"Every day discovering something brand new\\n\" +\n" +
                "                        \"I'm in love with the shape of you\\n\" +\n" +
                "                        \"Come on, be my baby, come on\\n\" +\n" +
                "                        \"Come on, be my baby, come on\\n\" +\n" +
                "                        \"Come on, be my baby, come on\\n\" +\n" +
                "                        \"Come on, be my baby, come on\\n\" +\n" +
                "                        \"Come on, be my baby, come on\\n\" +\n" +
                "                        \"Come on, be my baby, come on\\n\" +\n" +
                "                        \"Come on, be my baby, come on\\n\" +\n" +
                "                        \"Come on, be my baby, come on\\n\" +\n" +
                "                        \"I'm in love with the shape of you\\n\" +\n" +
                "                        \"We push and pull like a magnet do\\n\" +\n" +
                "                        \"Although my heart is falling too\\n\" +\n" +
                "                        \"I'm in love with your body\\n\" +\n" +
                "                        \"And last night you were in my room\\n\" +\n" +
                "                        \"And now my bedsheets smell like you\\n\" +\n" +
                "                        \"Every day discovering something brand new\\n\" +\n" +
                "                        \"I'm in love with your body\\n\" +\n" +
                "                        \"Come on, be my baby, come on\\n\" +\n" +
                "                        \"Come on (I'm in love with your body), be my baby, come on\\n\" +\n" +
                "                        \"Come on, be my baby, come on\\n\" +\n" +
                "                        \"Come on (I'm in love with your body), be my baby, come on\\n\" +\n" +
                "                        \"Come on, be my baby, come on\\n\" +\n" +
                "                        \"Come on (I'm in love with your body), be my baby, come on\\n\" +\n" +
                "                        \"Every day discovering something brand new\\n\" +\n" +
                "                        \"I'm in love with the shape of you"));
        library.addSong(new Song("Dai Dai", "Shakira", "Single", "Dance-pop",
                PlayTime.ofMinutesSeconds("3:44"), "Oh-eh-oh-eh (oh-eh)\\n\" +\n" +
                "                        \"Eh-oh-eh (oh-eh)\\n\" +\n" +
                "                        \"Oh-eh-oh-eh (oh-eh)\\n\" +\n" +
                "                        \"Eh-oh-eh\\n\" +\n" +
                "                        \"You knew from the day you were born\\n\" +\n" +
                "                        \"That here in this place, you belong\\n\" +\n" +
                "                        \"You've been this brave all along\\n\" +\n" +
                "                        \"What broke you once, made you strong\\n\" +\n" +
                "                        \"Dai, dai, ikou, dale, allez, let's go\\n\" +\n" +
                "                        \"Dai, dai, ikou, dale, allez, let's go\\n\" +\n" +
                "                        \"Come follow your desire\\n\" +\n" +
                "                        \"Where there's a will, there's a way\\n\" +\n" +
                "                        \"You are the owner of that fire\\n\" +\n" +
                "                        \"No one can take it away\\n\" +\n" +
                "                        \"Sweat and blood to write your story\\n\" +\n" +
                "                        \"That is how you paved the way\\n\" +\n" +
                "                        \"You're about to reach the glory\\n\" +\n" +
                "                        \"Only one step away\\n\" +\n" +
                "                        \"All the highs and lows\\n\" +\n" +
                "                        \"All the tears and the pain\\n\" +\n" +
                "                        \"You've been there through it all, been through it all\\n\" +\n" +
                "                        \"Just do it again\\n\" +\n" +
                "                        \"Now you got to believe (I believe)\\n\" +\n" +
                "                        \"'Cause you know what it takes\\n\" +\n" +
                "                        \"To be living my dream\\n\" +\n" +
                "                        \"At the top of your game\\n\" +\n" +
                "                        \"Feel it, got everything you needed\\n\" +\n" +
                "                        \"Now bring it like you mean it\\n\" +\n" +
                "                        \"Just like you mean it\\n\" +\n" +
                "                        \"Dale, no olvide' lo que vale'\\n\" +\n" +
                "                        \"Juega como tú sabes\\n\" +\n" +
                "                        \"Como tú sabe'\\n\" +\n" +
                "                        \"Energy's contagious (you know)\\n\" +\n" +
                "                        \"And it never fails (no, no)\\n\" +\n" +
                "                        \"No one's getting tired (I know)\\n\" +\n" +
                "                        \"'Cause you got that fire (ayo)\\n\" +\n" +
                "                        \"Dream a little higher\\n\" +\n" +
                "                        \"Let's go, let's go, let's go\\n\" +\n" +
                "                        \"Ayo\\n\" +\n" +
                "                        \"Ayo\\n\" +\n" +
                "                        \"We've taken all that our hearts can hold\\n\" +\n" +
                "                        \"And we can't hold on to the past no more\\n\" +\n" +
                "                        \"From the dirt and the tears, we make gold\\n\" +\n" +
                "                        \"And we are more than flesh and bones\\n\" +\n" +
                "                        \"All the highs and lows (highs and lows)\\n\" +\n" +
                "                        \"All the tears and the pain\\n\" +\n" +
                "                        \"You've been there through it all, been through it all\\n\" +\n" +
                "                        \"Just do it again\\n\" +\n" +
                "                        \"Now you got to believe (I believe)\\n\" +\n" +
                "                        \"'Cause you know what it takes\\n\" +\n" +
                "                        \"To be living my dream\\n\" +\n" +
                "                        \"At the top of your game\\n\" +\n" +
                "                        \"Feel it, got everything you needed\\n\" +\n" +
                "                        \"Now bring it like you mean it\\n\" +\n" +
                "                        \"Just like you mean it\\n\" +\n" +
                "                        \"Dale, no olvide' lo que vale'\\n\" +\n" +
                "                        \"Juega como tú sabes\\n\" +\n" +
                "                        \"Como tú sabe'\\n\" +\n" +
                "                        \"Pelé, Maradona, Maldini, Romário\\n\" +\n" +
                "                        \"Cristiano Ronaldo\\n\" +\n" +
                "                        \"El Pibe, Iniesta, Beckham y Kaká\\n\" +\n" +
                "                        \"Messi, Mbappé, Salah\\n\" +\n" +
                "                        \"Brasil, Uruguay, Argentina, Colombia\\n\" +\n" +
                "                        \"US, England, Germany, France\\n\" +\n" +
                "                        \"South Africa, España, México, Japan\\n\" +\n" +
                "                        \"Korea, Netherlands\\n\" +\n" +
                "                        \"Oh-eh-oh-eh (oh-eh)\\n\" +\n" +
                "                        \"Eh-oh-eh (oh-eh)\\n\" +\n" +
                "                        \"Oh-eh-oh-eh (oh-eh)\\n\" +\n" +
                "                        \"Eh-oh-eh\\n\" +\n" +
                "                        \"Knew from the day you were born\\n\" +\n" +
                "                        \"Here in this place, you belong\\n\" +\n" +
                "                        \"You've been this brave all along\\n\" +\n" +
                "                        \"What broke you once, made you strong (ow)\\n\" +\n" +
                "                        \"Dai, dai, ikou, dale, allez, let's go\\n\" +\n" +
                "                        \"Dai, dai, ikou, dale, allez, let's go\\n\" +\n" +
                "                        \"Dai, dai, ikou, dale, allez, let's go\\n\" +\n" +
                "                        \"Dai, dai, ikou, dale, allez, let's go"));
        library.addSong(new Song("Treat You Better", "Shawn Mendes", "Illuminate", "Pop",
                PlayTime.ofMinutesSeconds("4:16"), "I won't lie to you\\n\" +\n" +
                "                \"I know he's just not right for you\\n\" +\n" +
                "                \"And you can tell me if I'm off, but I see it on your face\\n\" +\n" +
                "                \"When you say that he's the one that you want\\n\" +\n" +
                "                \"And you're spendin' all your time in this wrong situation\\n\" +\n" +
                "                \"And anytime you want it to stop\\n\" +\n" +
                "                \"I know I can treat you better than he can\\n\" +\n" +
                "                \"And any girl like you deserves a gentleman\\n\" +\n" +
                "                \"Tell me, why are we wasting time on all your wasted cryin'\\n\" +\n" +
                "                \"When you should be with me instead?\\n\" +\n" +
                "                \"I know I can treat you better, better than he can\\n\" +\n" +
                "                \"I'll stop time for you\\n\" +\n" +
                "                \"The second you say you'd like me too\\n\" +\n" +
                "                \"I just wanna give you the lovin' that you're missing\\n\" +\n" +
                "                \"Baby, just to wake up with you\\n\" +\n" +
                "                \"Would be everything I need, and this could be so different\\n\" +\n" +
                "                \"Tell me what you want to do\\n\" +\n" +
                "                \"'Cause I know I can treat you better than he can\\n\" +\n" +
                "                \"And any girl like you deserves a gentleman\\n\" +\n" +
                "                \"Tell me, why are we wasting time on all your wasted cryin'\\n\" +\n" +
                "                \"When you should be with me instead?\\n\" +\n" +
                "                \"I know I can treat you better, better than he can\\n\" +\n" +
                "                \"Better than he can\\n\" +\n" +
                "                \"Give me a sign, take my hand, we'll be fine\\n\" +\n" +
                "                \"Promise, I won't let you down\\n\" +\n" +
                "                \"Just know that you don't have to do this alone\\n\" +\n" +
                "                \"Promise, I'll never let you down\\n\" +\n" +
                "                \"'Cause I know I can treat you better than he can\\n\" +\n" +
                "                \"And any girl like you deserves a gentleman\\n\" +\n" +
                "                \"Tell me, why are we wasting time on all your wasted cryin'\\n\" +\n" +
                "                \"When you should be with me instead?\\n\" +\n" +
                "                \"I know I can treat you better, better than he can, oh\\n\" +\n" +
                "                \"Better than he can\\n\" +\n" +
                "                \"Better than he can"));

        System.out.println("Pop songs: " + library.findByGenre("Pop").size());
        System.out.println("Ed Sheeran songs: " + library.findByArtist("Ed Sheeran").size());
        System.out.println("Songs mentioning 'treat': " + library.findByLyricsContaining("treat").size());
        System.out.println("Long songs (>4:30): " + library.findLongerThan(PlayTime.ofMinutesSeconds("4:30")).size());
        System.out.println("Total duration: " + library.totalDuration());

        for (var strategy : List.of(new TitleSortStrategy(), new ArtistSortStrategy(), new DurationSortStrategy(true))) {
            library.setSortStrategy(strategy);
            System.out.println("\n" + strategy.name() + ":");
            library.getSortedSongs().forEach(s -> System.out.println("  " + s));
        }
    }
}