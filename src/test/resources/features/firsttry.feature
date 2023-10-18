@urun_arama
  Feature: first_feature_arama

    Scenario: Google_urun_arama
      Given kullanici google sitesine gider
      When togg icin arama yapar
      Then sonuclarda togg oldugunu dogrular
      And sayfayi kapatir