package com.example.mapcountryzip.data

data class Country(
    val country: String,
    val countryCode: String,
    val postalCodeRange: String

)

val countries = listOf(
    Country("Andorra", "AD","AD100 : AD700"),
    Country("Argentina", "AR","1601 : 9431"),
    Country("American Samoa", "AS","96799 : 96799"),
    Country("Austria", "AT","1010 : 9992"),
    Country("Australia", "AU","0200 : 9726"),
    Country("Bangladesh", "BD","1000 : 9461"),
    Country("Belgium", "BE","1000 : 9992"),
    Country("Bulgaria", "BG","1000 : 9974"),
    Country("Brazil", "BR","01000-000 : 99990-000"),
    Country("Canada", "CA","A0A : Y1A"),
    Country("Switzerland", "CH","1000 : 9658"),
    Country("Czech Republic", "CZ","100 00 : 798 62"),
    Country("Germany", "DE","01067 : 99998"),
    Country("Denmark", "DK","0800 : 9990"),
    Country("Dominican Republic", "DO","10101 : 11906"),
    Country("Spain", "ES","01001 : 52080"),
    Country("Finland", "FI","00002 : 99999"),
    Country("Faroe Islands", "FO","100 : 970"),
    Country("France", "FR"," 01000 : 98799"),
    Country("Great Britain", "GB","AB1 : ZE3"),
    Country("French Guyana", "GF","97300 : 97390"),
    Country("Guernsey", "GG","GY1 : GY9"),
    Country("Greenland", "GL","2412 : 3992"),
    Country("Guadeloupe", "GP","97100 : 97190"),
    Country("Guatemala", "GT","01001 : 22027"),
    Country("Guam", "GU","96910 : 96932"),
    Country("Guyana", "GY","97312 : 97360"),
    Country("Croatia", "HR","10000 : 53296"),
    Country("Hungary", "HU","1011 : 9985"),
    Country("Isle of Man", "IM","IM1 : IM9"),
    Country("India", "IN","110001 : 855126"),
    Country("Iceland", "IS","101 : 902"),
    Country("Italy", "IT","00010 : 98168"),
    Country("Jersey", "JE","JE1 : JE3"),
    Country("Japan", "JP","100-0001 : 999-8531"),
    Country("Liechtenstein", "LI","9485 : 9498"),
    Country("Sri Lanka", "LK","* : 96167"),
    Country("Lithuania", "LT","00001 : 99069"),
    Country("Luxembourg", "LU","L-1009 : L-9999"),
    Country("Monaco", "MC","98000 : 98000"),
    Country("Moldavia", "MD","MD-2000 : MD-7731"),
    Country("Marshall Islands", "MH","96960 : 96970"),
    Country("Macedonia", "MK","1000 : 7550"),
    Country("Northern Mariana Islands", "MP","96950 : 96952"),
    Country("Martinique", "MQ","97200 : 97290"),
    Country("Mexico", "MX","01000 : 99998"),
    Country("Malaysia", "MY","01000 : 98859"),
    Country("Holland", "NL","1000 : 9999"),
    Country("Norway", "NO"," 0001 : 9991"),
    Country("New Zealand", "NZ","0110 : 9893"),
    Country("Phillippines", "PH","0400 : 9811"),
    Country("Pakistan", "PK","10010 : 97320"),
    Country("Poland", "PL","00-001 : 99-440"),
    Country("Saint Pierre and Miquelon", "PM","97500 : 97500"),
    Country("Puerto Rico", "PR"," 00601 : 00988"),
    Country("Portugal", "PT","1000-001 : 9980-999"),
    Country("French Reunion", "RE","97400 : 97490"),
    Country("Russia", "RU","101000 : 901993"),
    Country("Sweden", "SE","10005 : 98499"),
    Country("Slovenia", "SI","1000 : 9600"),
    Country("Svalbard & Jan Mayen Islands", "SJ","8099 : 9178"),
    Country("Slovak Republic", "SK","010 01 : 992 01"),
    Country("San Marino", "SM"," 47890 : 47899"),
    Country("Thailand", "TH","10100 : 96220"),
    Country("Turkey", "TR","01000 : 81950"),
    Country("United States", "US","00210 : 99950"),
    Country("Vatican", "VA","00120 : 00120"),
    Country("Virgin Islands", "VI","00801 : 00851"),
    Country("Mayotte", "YT","97600 : 97680"),
    Country("South Africa", "ZA","0002 : 9992")
)

