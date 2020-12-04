# curae

You can find cucumber feature with automation test here:
\curae_module\src\test\resources\features

To run autotest use:

mvn -am -pl curae_module clean test -Dcucumber.options=" --plugin io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm --plugin pretty --tags @createAccount"
or
use Idea to run

