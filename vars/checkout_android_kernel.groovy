def call(branch, num_parallel_jobs) {
	sh """
		mkdir -p android-kernel

		pushd android-kernel

		if [ ! -e .${branch} ]; then

			repo init -u https://android.googlesource.com/kernel/manifest -b ${branch}
			repo sync -cd -j ${num_parallel_jobs}
			touch .${branch}

		fi


		popd
	"""
}
