# Get FX Rates.
This java class will fetch the FX rates for Africa.<br>
This application depends on jsoup API https://jsoup.org/<br>
<br>
## Prepair your ENV
install Java openjdk<br>
sudo apt-get install openjdk-11-jdk-headless<br>
Get dependensie jar<jbr>
wget  https://jsoup.org/packages/jsoup-1.11.3.jar<br>
## Compiling the java code.
javac -cp ./jsoup-1.11.3.jar ./Get_fx_rates_from_SBSA.java<br>
<br>
## Run compiled java
java -cp ./jsoup-1.11.3.jar:. Get_fx_rates_from_SBSA<br>
## Rates update
It looks like the Rases update every 30min so no need to get an update les than 30 min.<br> 
Example of cron scedule.<br>
<br> 
## Configuering propertie File. 
There is a config.properties witch defines all the currensies you want to be calculated.<br>
Here is an exsample of the file.<br>
filename0=Rates.csv<br>
Currency1=AOA,GBP<br>
Currency2=AOA,USD<br>
Currency3=AOA,EUR<br>
Currency4=AOA,ZAR<br>
Currency5=AUD,ZAR<br>
Currency6=BWP,ZAR<br>
Currency7=CAD,ZAR<br>
Currency8=CHF,ZAR<br>
Currency9=CNY,ZAR<br>
<br>

## Calculating cross currensy
Example<br>
<br>
To calculate the cross-rate between Sterling (GBP) and the Mexican Peso (MXN), using the US Dollar (USD) as the common currency. Let us assume that rates are quoted as follows:<br>
<br>
    GBP / USD = 1.43130 / 1.43160<br>
    USD / MXN = 9.02000 / 9.03000<br>
<br>
    GBP / MXN = GBP / USD x USD / MXN<br>
    MXN / GBP = 1 GBP / USD  x  USD / MXN<br>
<br>
For GBP/MXN – to buy a variable amount of MXN per 1 GBP:<br>
<br>
    Bid = 1.43130 x 9.02000 = 12.91 - the bank buys GBP and sells MXN<br>
    Offer = 1.43160 x 9.03000 = 12.93 - the bank sells GBP and buys MXN<br>
    So GBP/MXN = 12.91 / 12.93<br>

For MXN/GBP – to buy a variable amount of GBP per 1 MXN:<br>

    Bid = 1 1.43160  x  9.03000 = 0.07735 - the bank buys MXN and sells GBP<br>
    Offer = 1 1.43130  x  9.02000 = 0.07746 - the bank sells MXN and buys GBP<br>
    So MXN/GBP = 0.07735 / 0.07746<br>
## Exsample of output.<br>
23 BRITSH POUND,GBP,18.1333,18.0864,18.0061,18.6173,18.7105<br>
30 EURO,EUR,16.1652,16.1188,16.0392,16.5989,16.6274<br>
37 UNITED STATES DOL,USD,13.9775,13.9146,13.9700,14.2950,14.2950<br>
45 UAE DIRHAM,AED,.2902,,.2740,.2283,.2525<br>
52 AUSTRALIAN DOLLAR,AUD,.1018,.1033,.1028,.0937,.0927<br>
59 BOTSWANA PULA,BWP,.8099,.8151,.8099,.6888,.6888<br>
66 CANADIAN DOLLAR,CAD,.0984,.0988,.1014,.0847,.0847<br>
73 SWISS FRANC,CHF,.0722,.0724,.0832,.0657,.0647<br>
80 CHINESE YUAN,CNY,.5373,,.4996,.4337,.4613<br>
87 CZECH KRONER,CZK,1.6757,2.3856,,1.4635,<br>
94 DANISH KRONER,DKK,.4852,.4871,.5062,.4239,.4239<br>
101 EGYPTIAN POUND,EGP,1.3022,,,1.2276,<br>
108 FIJI DOLLAR,FJD,.1560,,,.1436,<br>
115 GHANA CEDI,GHS,.3936,,,.3090,<br>
122 HONG KONG DOLLAR,HKD,.5772,.5805,.6292,.5273,.5273<br>
129 HUNGARIAN FORINT,HUF,21.3236,,,18.1694,<br>
136 ISRAELI SHEKEL,ILS,.2878,,.3478,.2258,.2258<br>
143 INDIAN RUPEE,INR,5.2899,5.3314,,4.9481,<br>
150 JAPANESE YEN,JPY,8.3925,8.3540,8.5390,7.6831,7.6717<br>
157 KENYAN SHILLING,KES,8.0507,8.1248,,6.1863,<br>
164 SRI LANKA RUPEE,LKR,12.1572,12.3446,,11.7218,<br>
171 LESOTHO LOTI,LSL,1.0000,,1.0000,1.0000,1.0000<br>
178 MOROCCAN DIRHAM,MAD,.6688,,,.6636,<br>
185 MALAGASY ARIARY,MGA,290.8572,,,187.0527,<br>
192 MAURITIAN RUPEE,MUR,2.5938,2.5561,2.5988,2.2555,2.2555<br>
199 MALAWI KWACHA,MWK,53.6587,54.6466,,49.0258,<br>
206 MEXICAN PESO,MXN,1.3388,,,1.3091,<br>
213 MOZAMBIQUE NETICA,MZN,4.5255,,,4.0247,4.1044<br>
220 NAMIBIA DOLLAR,NAD,1.0000,,1.0000,1.0000,1.0000<br>
227 NIGERIAN NAIRA,NGN,28.5473,23.9913,,19.5439,<br>
234 NORWEGIAN KRONOR,NOK,.6067,.6088,.6187,.5463,.5463<br>
241 NEW ZEALAND DOLLA,NZD,.1131,.1153,.1171,.1004,.0989<br>
248 PAKISTAN RUPEE,PKR,,,,7.8014,<br>
255 POLISH ZLOTY,PLN,.3015,,,.2196,<br>
262 QATAR RIYAL,QAR,.2880,,,.2260,<br>
269 ROMANIAN LEU,RON,.2852,,,.2828,<br>
276 RUSSIAN ROUBLE,RUB,4.6608,,,4.6242,<br>
283 RAWANDAN FRANC,RWF,67.1730,,,55.5399,<br>
290 SAUDI RIYALS,SAR,.2757,,.2857,.2538,.2438<br>
297 SWEDISH KRONER,SEK,.6563,.6587,.7113,.6016,.6016<br>
304 SINGAPORE DOLLAR,SGD,.1034,.1038,.1119,.0897,.0897<br>
311 SOUTH SUDAN POUND,SSP,10.8016,,,10.3079,<br>
318 SWAZILAND LILANGE,SZL,1.0000,,1.0000,1.0000,1.0000<br>
325 THAI BAHT,THB,2.5774,2.3815,2.6489,1.9892,1.9924<br>
332 TUNISIAN DINAR,TND,.1990,,,.1974,<br>
339 TURKISH LIRE,TRY,.4306,,,.4185,<br>
346 TANZANIA SHILLING,TZS,174.1392,,,148.2954,<br>
353 UGANDA SHILLING,UGX,301.3185,,,238.7066,<br>
360 CFA FRANC,XAF,52.3817,,,31.8022,<br>
367 SENEGALESE FRANC,XOF,49.9433,,,29.1700,<br>
374 ZAMBIAN KWACHA,ZMW,.8879,,,.8404,<br>

