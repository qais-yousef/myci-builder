def call(branch, num_parallel_jobs) {
	sh """
		mkdir -p android-kernel

		pushd android-kernel

		repo init -u https://android.googlesource.com/kernel/manifest \
			-b ${branch} --partial-clone --clone-filter=blob:limit=10M

		repo sync -cdq -j ${num_parallel_jobs}

		popd
	"""
}
