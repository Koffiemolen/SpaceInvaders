//package data.providers;
//
//import org.junit.Rule;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.rules.TemporaryFolder;
//import org.junit.runner.RunWith;
//
//import java.io.File;
//
//import static org.junit.jupiter.api.Assertions.*;
////@RunWith(PowerMockRunner.class)
//
//
//class HighscoreStoreTest {
//    private String highscoreFileValue;
//    private String highscoreFileNotPresent;
//    private String highscoreFileEmpty;
//    private HighscoreStore highscoreEmptyUserWithScore;
//    private HighscoreStore highscoreCorrectUserAndScore;
//    private HighscoreStore highscoreEmpty;
//    private HighscoreStore highscoreEmptyFileOnly;
//
//    @Rule
//    public TemporaryFolder folder = new TemporaryFolder();
//
//    @BeforeEach
//    void setUp() {
//        highscoreFileValue = "Berta22:23000";
//        highscoreFileNotPresent = "0";
//        highscoreFileEmpty = null;
//
//        String user2 = "";
//        int score2 = 5000;
//
//        String user3 = "";
//        int score3;
//        File testFile = new File("highscoreEmptyFileOnly.dat");
//        highscoreEmptyUserWithScore = new HighscoreStore("", 20000);
//        highscoreCorrectUserAndScore = new HighscoreStore("Berta", 1200);
//        highscoreEmptyFileOnly = new HighscoreStore(testFile);
//        highscoreEmpty = new HighscoreStore();
//    }
//
//    @Test
//    void getNameCorrectUserAndScore() {
//        // Arrange: Set up the test environment
//        String user = "Berta";
//
//        // Act: Act out the test scenario(s)
//
//        // Assert: Verify the results from the test.
//        assertEquals(user, highscoreCorrectUserAndScore.getName());
//    }
//
//    @Test
//    void getNameCorrectUserAndScore2() {
//        // Arrange: Set up the test environment
//        String user1 = "Henk";
//        int score1 = 10000;
//
//        // Act: Act out the test scenario(s)
//        HighscoreStore newHighscoreStore = new HighscoreStore(user1, score1);
//
//        // Assert: Verify the results from the test.
//        assertEquals(user1, newHighscoreStore.getName());
//    }
//
//    @Test
//    void getNameCorrectUserAndScore3() {
//        // Arrange: Set up the test environment
//
//        // Act: Act out the test scenario(s)
//
//        // Assert: Verify the results from the test.
//        assertEquals("", highscoreEmptyUserWithScore.getName());
//    }
//
//    @Test
//    void getNameUserWithNonAlpaCharAndScore() {
//        // Arrange: Set up the test environment
//        String user1 = "Henk:80000";
//        int score1 = 10000;
//
//        // Act: Act out the test scenario(s)
//        HighscoreStore newHighscoreStore = new HighscoreStore(user1, score1);
//
//        // Assert: Verify the results from the test.
//        assertEquals(user1, newHighscoreStore.getName());
//    }
//
//
//    @Test
//    void getPointsFromHighscoreWithUserAndScore() {
//        // Arrange: Set up the test environment
//
//        // Act: Act out the test scenario(s)
//
//        // Assert: Verify the results from the test.
//        assertEquals(1200, highscoreCorrectUserAndScore.getPoints());
//    }
//
//    @Test
//    void getPointsFromHighscoreWithoutUserAndWithScore() {
//        // Arrange: Set up the test environment
//
//        // Act: Act out the test scenario(s)
//
//        // Assert: Verify the results from the test.
//        assertEquals(20000, highscoreEmptyUserWithScore.getPoints());
//    }
//
//    @Test
//    void setPointsWithUserAndScore() {
//        // Arrange: Set up the test environment
//
//        // Act: Act out the test scenario(s)
//        highscoreCorrectUserAndScore.setPoints(25000);
//
//        // Assert: Verify the results from the test.
//        assertEquals(25000, highscoreCorrectUserAndScore.getPoints());
//    }
//
//    @Test
//    void setPointsWitouthUserAndWithScore() {
//        // Arrange: Set up the test environment
//
//        // Act: Act out the test scenario(s)
//        highscoreEmptyUserWithScore.setPoints(23000);
//
//        // Assert: Verify the results from the test.
//        assertEquals(23000, highscoreEmptyUserWithScore.getPoints());
//    }
//
//    @Test
//    void setHighscoreValueWithoutUserAndWithScore() {
//        // Arrange: Set up the test environment
//        int score = 2000;
//
//        // Act: Act out the test scenario(s)
//        highscoreEmptyUserWithScore.setHighscoreValue(score);
//
//        // Assert: Verify the results from the test.
//        assertEquals(20000, highscoreEmptyUserWithScore.getPoints());
//    }
//
//    @Test
//    void setHighscoreValueWithUserAndWithScore() {
//        // Arrange: Set up the test environment
//        int score = 22000;
//
//        // Act: Act out the test scenario(s)
//        highscoreCorrectUserAndScore.setHighscoreValue(score);
//
//        // Assert: Verify the results from the test.
//        assertEquals(22000, highscoreCorrectUserAndScore.getPoints());
//    }
//
//    @Test
//    void setHighscoreValueWithUserAndWithScoreButLowerThanHighscore() {
//        // Arrange: Set up the test environment
//        int score = 100;
//
//        // Act: Act out the test scenario(s)
//        highscoreCorrectUserAndScore.setHighscoreValue(score);
//
//        // Assert: Verify the results from the test.
//        assertEquals(1200, highscoreCorrectUserAndScore.getPoints());
//    }
//
//
//    @Test
//    void registerNewHighscore() {
//        // Arrange: Set up the test environment
//        File file = new File("testhighscorefile20.dat");
//
//        // Delete if exists, returns boolean false if not
//        System.out.println("File deleted? " + file.delete());
//
//        String user = "Berta";
//        int score = 1200;
//        boolean[] expected = new boolean[]{true, true};
//
//        // Act: Act out the test scenario(s)
//        highscoreEmptyFileOnly.registerNewHighscore(file, user, score);
//        boolean[] actual = new boolean[]{
//                highscoreCorrectUserAndScore.getName().equals(user),
//                highscoreCorrectUserAndScore.getPoints() == score};
//
//        System.out.println(highscoreCorrectUserAndScore.getName() == user);
//        System.out.println(highscoreCorrectUserAndScore.getPoints() == score);
//
//        // Assert: Verify the results from the test.
//        assertTrue(AssertArraysAreEqual(expected, actual));
//    }
//
//    private boolean AssertArraysAreEqual(boolean[] expected, boolean[] actual) {
//        boolean lengthsAreSame = (expected.length == actual.length);
//        boolean elementsAreSame = true;
//        for (int i = 0; i < expected.length; i++) {
//            if (expected[i] != actual[i]) {
//                elementsAreSame = false;
//                return false;
//            }
//        }
//
//        if (!lengthsAreSame) {
//            return false;
//        } else if (!elementsAreSame) {
//            return false;
//        }
//        return true;
//    }
//
//
//}