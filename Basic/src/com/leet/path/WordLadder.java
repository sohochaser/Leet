package com.leet.path;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <ol>
 * Given two words (start and end), and a dictionary, find the length of
 * shortest transformation sequence from start to end, such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the dictionary For example,
 * 
 * Given: start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"] As
 * one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Note: Return 0 if there is no such transformation sequence. All words have
 * the same length. All words contain only lower case alphabetic characters.
 * </ol>
 * 
 * @author Allen
 * 
 */
public class WordLadder {
	public int ladderLength(String start, String end, HashSet<String> dict) {
		Set<Character> tmpSet = new HashSet<Character>();
		if (distance(start, end, tmpSet) < 25) {
			return 2;
		}
		int[][] dis = new int[dict.size() + 2][dict.size() + 2];

		String[] words = new String[dict.size() + 2];
		words[0] = start;
		words[words.length - 1] = end;
		int idx = 1;
		for (String str : dict) {
			words[idx++] = str;
		}

		Set<Integer> in = new HashSet<Integer>();
		Set<Integer> out = new HashSet<Integer>();
		boolean[] flag = new boolean[words.length];
		for (int i = 0; i < words.length; i++) {
			dis[i][i] = Integer.MAX_VALUE;
			for (int j = i + 1; j < words.length; j++) {
				dis[i][j] = distance(words[i], words[j], tmpSet);
				dis[j][i] = dis[i][j];

				if (dis[j][i] <= 1) {
					flag[i] = true;
					flag[j] = true;
				}
			}
			out.add(i);
		}
		
		for(int i=0;i<flag.length;i++){
			if(!flag[i]){			
				out.remove(i);
			}
			
		}

		in.add(0);
		out.remove(0);
		while (out.size() > 0) {
			int min = Integer.MAX_VALUE;
			List<Integer> mixList = new ArrayList<Integer>();
			for (int j : out) {
				if (dis[0][j] < min) {
					min = dis[0][j];
					mixList.clear();
					mixList.add(j);
				} else if (dis[0][j] == min) {
					mixList.add(j);
				}
			}

			if (min < Integer.MAX_VALUE) {
				for (int minIdx : mixList) {
					out.remove(minIdx);
				}
				for (int minIdx : mixList) {
					for (int i : in) {
						for (int j : out) {
							if (dis[i][j] - dis[i][minIdx] > dis[minIdx][j]) {
								dis[i][j] = dis[i][minIdx] + dis[minIdx][j];
							}
						}
					}
				}
				for (int minIdx : mixList) {
					if (words[minIdx].equals(end)) {
						return dis[0][minIdx] + 1;
					}
					in.add(minIdx);
				}
			} else {
				return 0;
			}
		}
		return 0;
	}

	private int distance(String s1, String s2, Set<Character> set) {
		set.clear();
		for (int i = 0; i < s1.length(); i++) {
			set.add(s1.charAt(i));
		}
		for (int i = 0; i < s2.length(); i++) {
			Character c = s2.charAt(i);
			if (set.contains(c)) {
				set.remove(c);
			}
		}
		if (set.size() > 1) {
			return Integer.MAX_VALUE;
		} else if (set.size() == 1) {
			return 1;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		HashSet<String> dict = new HashSet<String>();
		String[] strs = new String[] { "dose", "ends", "dine", "jars", "prow",
				"soap", "guns", "hops", "cray", "hove", "ella", "hour", "lens",
				"jive", "wiry", "earl", "mara", "part", "flue", "putt", "rory",
				"bull", "york", "ruts", "lily", "vamp", "bask", "peer", "boat",
				"dens", "lyre", "jets", "wide", "rile", "boos", "down", "path",
				"onyx", "mows", "toke", "soto", "dork", "nape", "mans", "loin",
				"jots", "male", "sits", "minn", "sale", "pets", "hugo", "woke",
				"suds", "rugs", "vole", "warp", "mite", "pews", "lips", "pals",
				"nigh", "sulk", "vice", "clod", "iowa", "gibe", "shad", "carl",
				"huns", "coot", "sera", "mils", "rose", "orly", "ford", "void",
				"time", "eloy", "risk", "veep", "reps", "dolt", "hens", "tray",
				"melt", "rung", "rich", "saga", "lust", "yews", "rode", "many",
				"cods", "rape", "last", "tile", "nosy", "take", "nope", "toni",
				"bank", "jock", "jody", "diss", "nips", "bake", "lima", "wore",
				"kins", "cult", "hart", "wuss", "tale", "sing", "lake", "bogy",
				"wigs", "kari", "magi", "bass", "pent", "tost", "fops", "bags",
				"duns", "will", "tart", "drug", "gale", "mold", "disk", "spay",
				"hows", "naps", "puss", "gina", "kara", "zorn", "boll", "cams",
				"boas", "rave", "sets", "lego", "hays", "judy", "chap", "live",
				"bahs", "ohio", "nibs", "cuts", "pups", "data", "kate", "rump",
				"hews", "mary", "stow", "fang", "bolt", "rues", "mesh", "mice",
				"rise", "rant", "dune", "jell", "laws", "jove", "bode", "sung",
				"nils", "vila", "mode", "hued", "cell", "fies", "swat", "wags",
				"nate", "wist", "honk", "goth", "told", "oise", "wail", "tels",
				"sore", "hunk", "mate", "luke", "tore", "bond", "bast", "vows",
				"ripe", "fond", "benz", "firs", "zeds", "wary", "baas", "wins",
				"pair", "tags", "cost", "woes", "buns", "lend", "bops", "code",
				"eddy", "siva", "oops", "toed", "bale", "hutu", "jolt", "rife",
				"darn", "tape", "bold", "cope", "cake", "wisp", "vats", "wave",
				"hems", "bill", "cord", "pert", "type", "kroc", "ucla", "albs",
				"yoko", "silt", "pock", "drub", "puny", "fads", "mull", "pray",
				"mole", "talc", "east", "slay", "jamb", "mill", "dung", "jack",
				"lynx", "nome", "leos", "lade", "sana", "tike", "cali", "toge",
				"pled", "mile", "mass", "leon", "sloe", "lube", "kans", "cory",
				"burs", "race", "toss", "mild", "tops", "maze", "city", "sadr",
				"bays", "poet", "volt", "laze", "gold", "zuni", "shea", "gags",
				"fist", "ping", "pope", "cora", "yaks", "cosy", "foci", "plan",
				"colo", "hume", "yowl", "craw", "pied", "toga", "lobs", "love",
				"lode", "duds", "bled", "juts", "gabs", "fink", "rock", "pant",
				"wipe", "pele", "suez", "nina", "ring", "okra", "warm", "lyle",
				"gape", "bead", "lead", "jane", "oink", "ware", "zibo", "inns",
				"mope", "hang", "made", "fobs", "gamy", "fort", "peak", "gill",
				"dino", "dina", "tier" };
		for (String str : strs) {
			dict.add(str);
		}

		String start = "nape";
		String end = "mild";
		System.out.println(new WordLadder().ladderLength(start, end, dict));
	}
}