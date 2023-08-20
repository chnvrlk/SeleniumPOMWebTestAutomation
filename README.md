# SeleniumWebTestAutomation
Page object model test automation project / Selenium 4 TestNG / Extent report

Merhabalar, Proje bir web uygulama test otomasyon projesidir.

Proje mimari olarak Page Object Model oluşturulmuştur.

Projede kullandığım bağımlılıklar; selenium, testng, extent reports...

Projede testng ve xml dosyaları sayesinde paralel test koşumu, çoklu test koşumları gerçekleştirebildim. Junit yerine testNg kullanarak farklı kütüphanelerinde özelliklerini keşfetmiş oldum.
Yine projede data provider özelliği ile excel dosyasındaki verilerle aynı testi farklı verilerle koşabiliyoruz.

Test-output klasörüne Extent.html dosyasına test koşumu sonra görsel ve faydalı bir rapor oluşturulur.

src/java ... /example içerisinde testdata paketi içerisinde excel dosyasında test koşumunda kullanılan test verileri bulunuyor.

src/java ... /example içerisinde yine testdata paketi içerisinde testdata.properties dosyasında ise invalid password, invalid email gibi sürekli kullanılabilecek değerleri bulunduruyoruz. Bu dosya içerisindeki verileri birden fazla test senaryolarında kullanabiliyoruz. Kodun içerisinde test datası yazmaktansa dataları dosyadan yönetmeyi uygun buluyorum.

src/java ... /example içerisinde pages kısmında nesneye yönelik test ettiğimiz uygulamadaki sayfaların classları ve bu classların içerisinde ise buradaki elementlerin değerleri ve elemente tıklama gibi methodlar bulunmaktadır.

src/test ... /example içerisinde base kısmında ise test çalışırken hangi browser ile açılacak gibi configurasyon yaptığımız kısımdır.

src/test ... /example içerisinde testcases kısmı ise @Test tagi ile test senaryolarının yazıldığı alandır.

----------------------------------------------------
Hi,
The project is a web application test automation project.

Page Object Model was created as the project architecture.

The dependencies I used in the project; selenium, testng, extent reports...

Thanks to the testng and xml files in the project, I was able to perform parallel test runs and multiple test runs. By using testNg instead of Junit, I discovered its features in different libraries.
Again, with the data provider feature in the project, we can run the same test with different data with the data in the excel file.

After the test run, a visual and useful report is generated in the Extent.html file in the test-output folder.

In the testdata package in src/java ... /example, the excel file contains the test data used in the test run.

In src/java ... /example, we have values that can be used continuously, such as invalid password and invalid email, in the testdata.properties file in the testdata package. We can use the data in this file in more than one test scenario. I find it convenient to manage the data from the file rather than writing test data in the code.

In the pages section of src/java ... /example, there are the classes of the pages in the application that we tested for the object, and within these classes there are the values of the elements here and methods such as clicking on the element.

In the base part of src/test ... /example, it is the part where we configure which browser to open while the test is running.

The testcases section in src/test ... /example is the field where test cases are written with the @Test tag.
