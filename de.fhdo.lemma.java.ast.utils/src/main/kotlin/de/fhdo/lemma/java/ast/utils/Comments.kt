@file:Suppress("unused")
package de.fhdo.lemma.java.ast.utils

import com.github.javaparser.ast.comments.BlockComment
import com.github.javaparser.ast.comments.Comment
import com.github.javaparser.ast.stmt.ExpressionStmt

/**
 * Add comments to this [ExpressionStmt]. The [additionalComments] are appended to the list of [comments]. Note that in
 * any case [createCompositeComment] will be called with all given [Comment] instances and that the resulting composite
 * [Comment] will be added to the [ExpressionStmt].
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
internal fun ExpressionStmt.addComments(comments: List<Comment>, vararg additionalComments: Comment) {
    if (comments.isEmpty() && additionalComments.isEmpty())
        return

    val commentsToAdd = comments.toMutableList()
    commentsToAdd.addAll(additionalComments)
    val compositeComment = createCompositeComment(commentsToAdd) ?: return
    setComment(compositeComment)
}

/**
 * Create a composite [Comment] from the given list of [comments] or null, if the list is empty. A composite [Comment]
 * comprises all passed comments' contents. If there is more than one passed comment, a new [BlockComment] will be
 * created that holds the contents of all passed [comments] separated by a linebreak.
 *
 * @author [Florian Rademacher](mailto:florian.rademacher@fh-dortmund.de)
 */
private fun createCompositeComment(comments: List<Comment>) : Comment? {
    return when {
        comments.isEmpty() -> null
        comments.size == 1 -> return comments[0]
        else -> BlockComment(comments.joinToString("\n") { it.content })
    }
}