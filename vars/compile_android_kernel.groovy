def call() {
	sh """
		pushd android-kernel

		build_script=`ls build*.sh | grep -vE '(mixed|test)'`

		# In age of GKI, this is required to not use prebuilts
		export BUILD_KERNEL=1

		if [ "x\$build_script" == "x" ]; then
			./build/build.sh
		else
			./build_slider.sh
		fi

		popd
	"""
}
