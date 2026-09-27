set -eu
test ! -e /work
mkdir -p /results/consumer/src/main/kotlin
cp /sdk/conformance/stream-kotlin/src/main/kotlin/Consumer.kt /results/consumer/src/main/kotlin/
cp /suite/kotlin/settings.gradle /results/consumer/settings.gradle
cp /suite/kotlin-retained.gradle /results/consumer/build.gradle
REACON_CONSUMER_MAIN=ConsumerKt REACON_EXPECTED_JAVA_MAJOR=21 \
  REACON_RETAINED_JAR="/artifacts/reacon-kotlin-$REACON_SDK_PACKAGE_VERSION.jar" \
  gradle -p /results/consumer --no-daemon --console=plain run
