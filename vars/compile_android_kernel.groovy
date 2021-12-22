def call() {
	sh """
		pushd android-kernel

		./build/build.sh

		popd
	"""
}
