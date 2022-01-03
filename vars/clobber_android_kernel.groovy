def call() {
	sh """
		if [ -d android-kernel ]; then
			pushd android-kernel
			repo forall -c git clean -xdf
			popd
		fi
	"""
}
