def call() {
	sh """
		if [ -d android-kernel ]; then
			pushd android-kernel
			rm -rf out
			repo forall -c git clean -xdf
			popd
		fi
	"""
}
