def call(branch) {
	sh """
		pushd aosp

		repo forall -c "git format-patch --suffix=\\"--myci.patch\\" ${branch}..HEAD" || true

		popd
	"""
}
