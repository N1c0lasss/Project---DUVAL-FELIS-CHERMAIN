(ns chatbot-dcf.core
  (:gen-class))

(def park-data 
{"bertramka":
    {"wc": true,
     "attractions": "cultural monument, classical music concerts, social events, W. A. ​​Mozart Museum",
     "biking": true,
     "skating": false,
     "sports": false,
     "playground": false,
     "transportation": "trams No. 4, 7, 9, 10, 58, 59.",
     "parking": true},

"frantiskanska-zahrada":
    {"wc": true,
    "attractions": "Church of Our Lady of the Snows",
    "biking": true,
    "skating": false,
    "sports": false,
    "playground": true,
    "dogs": false,
    "transportation": "Václavské náměstí trams. No. 3, 9, 14, 24, 51, 52, 54, 55, 56, 58, metro A, B Můstek",
    "parking": false},

"obora-hvezda":
    {"wc": true,
    "attractions": "memorial trees, nature trail, nature attractions",
    "biking": true,
    "skiing": true,
    "skating": false,
    "sports": false,
    "playground": true,
    "dogs": true,
    "transportation": "Nad Markétou, bus no. 179, 184, 191, 510, Libocká - bus no. 179, 510, Vypich, tram no. 15, 22, 25, 57",
    "parking": true},

"kampa":
    {"wc": true,
    "attractions": "view of the Vltava, Sovovy Mlýny Gallery, Čertovka, Charles Bridge, Werich House, memorial trees.",
    "biking": true,
    "skating": true,
    "sports": false,
    "playground": true,
    "transportation": "Hellichova tram no. 12, 20, 22, 23, 57, Újezd ​​tram no. 6, 9, 22, 23, 57, 58, 59",
    "parking": false},

"kinskeho-zahrada":
    {"wc": true,
    "attractions": "museum,ornamental lakes, natural attraction - Petrin Rocks.",
    "biking": false,
    "skating": false,
    "sports": false,
    "playground": true,
    "transportation": "Kobrova - BUS No. 176",
    "parking": true},

"klamovka":
    {"wc": true,
    "attractions": "art gallery, historical attractions, music club, garden restaurant.",
    "biking": true,
    "skating": false,
    "sports": true,
    "dogs": true,
    "playground": true,
    "transportation": "Klamovka - BUS No. 149, 191, 217, tram No. 4, 7, 9, 10, 58, 59",
    "parking": false,
    "restaurant": true},

"ladronka":
    {"wc": true,
    "attractions": "extensive leisure area, music and entertainment events",
    "biking": true,
    "skating": true,
    "sports": false,
    "playground": true,
    "dogs": true,
    "transportation": "U Ladronky, Rozýnova, Štefkova BUS No. 191, Vypich BUS No. 108, 174, 180, 191, I3, tram No. 15, 22, 25, 57",
    "parking": true,
    "restaurant": true},

"letna":
    {"wc": true,
    "attractions": "extensive leisure area, cultural events",
    "biking": true,
    "skating": true,
    "sports": "777 789 140",
    "playground": true,
    "dogs": true,
    "transportation": "Letenské náměstí and Sparta tram no. 1, 8, 15, 25, 26, 51, 56, Čechův most tram no. 12, 17, 53, Chotkovy sady tram no. 18, 20, 57, metro Hradčanská",
    "parking": true,
    "restaurant": true},

"petrin":
    {"wc": true,
    "attractions": "lookout tower, maze, observatory, underground galleries and fruit orchards",
    "biking": true,
    "skating": true,
    "sports": false,
    "playground": true,
    "transportation": "Újezd ​​tram no. 6, 9, 12, 20, 22, 23, 57, 58, 59, Hellichova tram no. 12, 20, 22, 23, 57, Pohořelec tram no. 22, 23, Dormitories Strahov BUS No. 143, 149, 217",
    "parking": true,
    "restaurant": true},

"riegrovy-sady":
    {"wc": true,
    "attractions": "view of Prague, classicist lookout tower, three-sided obelisk",
    "biking": true,
    "skating": true,
    "sports": true,
    "playground": true,
    "dogs": true,
    "transportation": "Metro Jiřího z Poděbrad, Na Smetance Bus no. 135, Italská and Vinohradská tržnice tram no. 11",
    "parking": false,
    "restaurant": true},

"stromovka":
    {"wc": true,
    "attractions": "zoo, botanical gardens, natural attractions, planetarium, exhibition grounds",
    "biking": true,
    "skating": true,
    "sports": true,
    "playground": true,
    "dogs": true,
    "transportation": "Výstaviště, tram no. 5, 12, 14, 15, 17, 53, 54, Sibiřské nám., Bus no. 131, by steamer from Rašínov nábř.",
    "parking": true,
    "restaurant": true},

"vysehrad":
    {"wc": true,
    "attractions": "sightseeing, museum, cemetery of famous personalities Slavín, national cultural monument",
    "biking": true,
    "skating": false,
    "sports": true,
    "playground": true,
    "transportation": "Vyšehrad - metro C, Podolská vodárna tram no. 3, 16, 17, 21, 52",
    "parking": true}}
)

(def pos #{"yes" "Y" "yep" "y" "ok" "OK" "Yeah" "Yes" "fine"})
(def neg #{"no" "Nah" "nah" "n" "No" "nope" "nop" "Nope" "Nop" "nay"})
(def park #{"parking" "car" "driving" "drive"})
(def sport #{"sports" "sport" "exercise" "training"})
(def children #{"playground" "child" "children" "family" "son" "daughter"})
(def transport #{"how to go" "going" "transports" "transport"})
(def interest #{"what can I do" "activities" "attractions" "interests" "tourism"})

(defn exit
  "ends dialogue"
  []
  (println (str "Thanks for using our chatbot ! See you later !"))
  )

(defn whichpark
  "returns the index of the park in the JSON file"
  []
  (println "What's the name of the park you would like to visit ?")
  (println "here's an exhaustive list of parks in Prague")
  ()
  (let [x (read-line)]
    (cond 
      :else (notunderstand whichpark)))
) ;; find a way to look for the name in the set

(defn hello
  []
  (println "Hello ! Welcome to the park discovery chatbot ! Would you like to visit a park ?")
  (let [x (read-line)]
    (cond
      (contains? pos x) (whichpark)
      (contains? neg x) (exit)
      :else (notunderstand hello)))
  )

(defn notunderstand
  [fonc]
  (println "I did not understand can you please reformule ?")

  (fonc))

(defn -main
  []
  (hello))

(defn toilet
  [])
