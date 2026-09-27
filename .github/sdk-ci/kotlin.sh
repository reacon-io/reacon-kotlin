set -eu
sh /suite/kotlin-package.sh
cp -r /sdk/conformance/stream-kotlin /results/stream-consumer
REACON_TEST_URL="$REACON_STREAM_TEST_URL" gradle -p /results/stream-consumer --no-daemon --console=plain run
