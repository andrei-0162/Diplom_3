# Diplom_3
# запуск с Chrome
осуществляется по дефолту
```bash
mvn test
```

# запуск с FireFox
осуществляется с ипользованием параметра
```bash
mvn -Dbrowser=firefox test
```

# запуск с Yandex
осуществляется с ипользованием параметра
```bash
mvn -Dbrowser=yandex test
```

# запуск с FireFox
осуществляется с ипользованием параметра
```bash
mvn -Dbrowser=firefox -Dwebdriver.firefox.bin=/c:/WebDriver/bin/firefox test
```

# запуск с Yandex
осуществляется с ипользованием параметра
```bash
mvn -Dbrowser=yandex -Dwebdriver.yandex.bin=/c:/WebDriver/bin/yandex test
```